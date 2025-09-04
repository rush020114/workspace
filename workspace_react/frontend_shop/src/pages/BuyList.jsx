import React, { useEffect, useState } from 'react'
import styles from './BuyList.module.css'
import PageTitle from '../common/PageTitle'
import Button from '../common/Button'
import Input from '../common/Input'
import Select from '../common/Select'
import axios from 'axios'
import dayjs from 'dayjs'
import BuyListModal from './BuyListModal'


const BuyList = () => {

  // 구매 상세 내역 리스트를 저장할 state 변수
  const [buyDetail, setBuyDetail] = useState([]);

  // 구매상세내역 모달창 숨김/보이기 여부
  const [isOpenBuyModal, setIsOpenBuyModal] = useState(false);

  // 구매 조회를 저장할 state 변수
  const [buyList, setBuyList] = useState([]);

  // 구매 목록을 조회할 useEffect
  useEffect(() => {
    axios.get('/api/buys/buy-list-admin')
    .then(res => setBuyList(res.data))
    .catch(e => console.log(e));
  }, []);

  // 행 클릭 시 구매 상세 조회
  const getDetail = orderNum => {
    axios.get(`/api/buys/${orderNum}`)
    .then(res => setBuyDetail(res.data))
    .catch(e => console.log(e));
  };

  console.log(isOpenBuyModal)

  return (
    <div className={styles.container}>
      <div>
        <PageTitle 
          title='구매 이력 조회'
        />
      </div>
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
          <Input 
            type='date'
          />- 
          <Input 
            type='date'
          />
        </div>
        <div>
          <Button
            title='검 색'
          />
        </div>
      </div>
      <div className={styles.table_div}>
        <p>{`총 ${buyList.length}건이 검색되었습니다.`}</p>
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
                  <tr key={i}
                    onClick={() => {
                      setIsOpenBuyModal(true);
                      getDetail(e.orderNum);
                    }}
                  >
                    <td>{buyList.length - i}</td>
                    <td>{e.orderNum}</td>
                    <td>{e.title}</td>
                    <td>{e.memId}</td>
                    <td>{e.price.toLocaleString()}원</td>
                    <td>{dayjs(e.buyDate).format('YYYY.MM.DD HH:mm:ss')}</td>
                  </tr>
                )
              })
            }
          </tbody>
        </table>
      </div>
      <BuyListModal 
        isOpenBuyModal={isOpenBuyModal}
        onClose={() => setIsOpenBuyModal(false)}
        buyDetail={buyDetail}
      />
    </div>
  )
}

export default BuyList