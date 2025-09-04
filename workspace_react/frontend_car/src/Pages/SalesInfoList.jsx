import React, { useEffect, useState } from 'react'
import styles from './SalesInfoList.module.css'
import axios from 'axios';
import dayjs from 'dayjs';

const SalesInfoList = () => {

  // 조회한 판매 목록을 저장할 state 변수
  const [salesList, setSalesList] = useState([]);

  // 판매 목록을 받아올 useEffect
  useEffect(() => {
    axios.get('/api/sales-infos')
    .then(res => setSalesList(res.data))
    .catch(e => console.log(e));
  }, []);

  console.log(salesList)

  return (
    <div className={styles.container}>
      <h1><span><i className="bi bi-car-front"></i></span> 판매 목록 조회</h1>
      <div className={styles.content}>
        <table className={styles.table}>
          <colgroup>
            <col width='14.28%' />
            <col width='14.28%' />
            <col width='14.28%' />
            <col width='14.28%' />
            <col width='14.28%' />
            <col width='14.28%' />
            <col width='14.28%' />
          </colgroup>
          <thead>
            <tr>
              <td rowSpan={2}>No</td>
              <td colSpan={4}>구매자 정보</td>
              <td colSpan={2}>차량정보</td>
            </tr>
            <tr>
              <td>구매자명</td>
              <td>연락처</td>
              <td>구매일</td>
              <td>색상</td>
              <td>모델명</td>
              <td>가격</td>
            </tr>
          </thead>
          <tbody>
          {
            salesList.map((sales, i) => {
              return(
                <tr key={i}>
                  <td>{salesList.length - i}</td>
                  <td>{sales.buyer}</td>
                  <td>{sales.buyerTel ? sales.buyerTel : '-'}</td>
                  <td>{dayjs(sales.salesDate).format('YYYY.MM.DD HH:mm')}</td>
                  <td>{sales.color}</td>
                  <td>{sales.carDTO.modelName}</td>
                  <td>{`${sales.carDTO.price.toLocaleString()}원`}</td>
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

export default SalesInfoList