import React, { useEffect, useState } from 'react'
import styles from './BuyList.module.css'
import PageTitle from '../common/PageTitle'
import Button from '../common/Button'
import Input from '../common/Input'
import Select from '../common/Select'
import axios from 'axios'
import dayjs from 'dayjs'


const BuyList = () => {

  // 구매 조회를 저장할 state 변수
  const [buyList, setBuyList] = useState([]);

  // 구매 목록을 조회할 useEffect
  useEffect(() => {
    axios.get('/api/buys/buy-list-admin')
    .then(res => setBuyList(res.data))
    .catch(e => console.log(e));
  }, [])

  return (
    <div className={styles.container}>
      <div><PageTitle /></div>
      <div className={styles.search_div}>
        <div>
          <p>주문번호</p>
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
              <td>구매번호</td>
              <td>구매상품</td>
              <td>구매자ID</td>
              <td>결제금액</td>
              <td>구매일시</td>
            </tr>
          </thead>
          <tbody>
            {
              buyList.map((e, i) => {
                return(
                  <tr key={i}>
                    <td>{buyList.length - i}</td>
                    <td>{e.orderNum}</td>
                    <td>{e.title}</td>
                    <td>{e.memId}</td>
                    <td>{e.price.toLocaleString()}</td>
                    <td>{dayjs(e.buyDate).format('YYYY.MM.DD HH:mm:ss')}</td>
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