import React, { useEffect, useState } from 'react'
import styles from './BuyList.module.css'
import PageTitle from '../common/PageTitle'
import Button from '../common/Button'
import Input from '../common/Input'
import Select from '../common/Select'
import axios from 'axios'
import dayjs from 'dayjs'
import BuyListModal from '../components/BuyListModal'


const BuyList = () => {

  // 상세 구매 내역을 받아올 state 변수
  const [buyDetail, setBuyDetail] = useState([]);

  // 상세 구매 내역 보이기/안보이기 여부를 저장할 state 변수
  const [isOpenBuyDetail, setIsOpenBuyDetail] = useState(false);

  // 관리자의 사용자 구매이력을 저장할 state 변수
  const [buyList, setBuyList] = useState([]);

  // 관리자의 사용자 구매이력을 받아올 useEffect
  useEffect(() => {
    axios.get('/api/buys/buy-list-admin')
    .then(res => setBuyList(res.data))
    .catch(e => console.log(e));
  }, []);

  // 상세 구매 내역을 받아올 함수
  const getDetail = orderNum => {
    axios.get(`/api/buys/${orderNum}`)
    .then(res => setBuyDetail(res.data))
    .catch(e => console.log(e));
  };

  console.log(buyDetail)
  
  return (
    <div className={styles.container}>
      <div>
        <PageTitle 
          title='구매 이력 조회'
        />
      </div>
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
          <Input 
            type='date'
          />- 
          <Input 
            type='date'
          />
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
                  <tr 
                    key={i}
                    onClick={() => {
                      setIsOpenBuyDetail(true);
                      getDetail(buy.orderNum);
                    }}
                  >
                    <td>{buyList.length - i}</td>
                    <td>{buy.orderNum}</td>
                    <td>{buy.title}</td>
                    <td>{buy.memId}</td>
                    <td>{buy.price.toLocaleString()}원</td>
                    <td>{dayjs(buy.buyDate).format('YYYY.MM.DD HH:mm:ss')}</td>
                  </tr>
                )
              })
            }
          </tbody>
        </table>
      </div>
      <BuyListModal 
        buyDetail={buyDetail}
        isOpenBuyDetail={isOpenBuyDetail}
        onClose={() => setIsOpenBuyDetail(false)}
      />
    </div>
  )
}

export default BuyList