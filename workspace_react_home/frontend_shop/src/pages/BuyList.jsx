import React, { useEffect, useState } from 'react'
import styles from './BuyList.module.css'
import PageTitle from '../common/PageTitle'
import Button from '../common/Button'
import Input from '../common/Input'
import Select from '../common/Select'
import axios from 'axios'
import dayjs from 'dayjs'


const BuyList = () => {

  // 관리자의 사용자 구매이력을 저장할 state 변수
  const [buyList, setBuyList] = useState([]);

  // 관리자의 사용자 구매이력을 받아올 useEffect
  useEffect(() => {
    axios.get('/api/buys/buy-list-admin')
    .then(res => setBuyList(res.data))
    .catch(e => console.log(e));
  }, []);

  console.log(buyList)
  
  return (
    <div className={styles.container}>
      <div><PageTitle /></div>
      <div className={styles.search_div}>
        <div>
          <p>구매번호</p>
          <Input />
        </div>
        <div>
          <p>구매자ID</p>
          <Input />
        </div>
        <div>
          <p>구매일시</p>
          <Input />- 
          <Input />
        </div>
        <div>
          <Button></Button>
        </div>
      </div>
      <div className={styles.table_div}>
        <table className={styles.table}>
          <thead>
            <tr>
              <td>No</td>
              <td>주문번호</td>
              <td>구매상품</td>
              <td>구매자ID</td>
              <td>결제금액</td>
              <td>구매일시</td>
            </tr>
          </thead>
          <tbody>
            {
              buyList.map((buy, i) => {
                return(
                  <tr key={i}>
                    <td>{buyList.length - i}</td>
                    <td>{buy.orderNum}</td>
                    <td>{buy.title}</td>
                    <td>{buy.memId}</td>
                    <td>{buy.price.toLocaleString()}</td>
                    <td>{dayjs(buy.buyDate).format('YYYY.MM.DD HH:mm:ss')}</td>
                  </tr>
                )
              })
            }
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default BuyList