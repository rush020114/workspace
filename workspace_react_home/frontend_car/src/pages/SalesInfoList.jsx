import React, { useEffect, useState } from 'react'
import styles from './SalesInfoList.module.css'
import axios from 'axios';
import dayjs from 'dayjs';

const SalesInfoList = () => {

  // 판매 정보 조회를 저장할 state 변수
  const [salesList, setSalesList] = useState([]);

  // 판매 정보를 조회할 useEffect
  useEffect(() => {
    axios.get('/api/sales-infos')
    .then(res => setSalesList(res.data))
    .catch(e => console.log(e));
  }, []);

  return (
    <div>
      <table>
        <thead>
          <tr>
            <td rowSpan={2}>No</td>
            <td colSpan={4}>구매자 정보</td>
            <td colSpan={2}>차량 정보</td>
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
            salesList.map((e, i) => {
              return(
                <tr key={i}>
                  <td>{salesList.length - i}</td>
                  <td>{e.buyer}</td>
                  <td>{e.buyerTel ? e.buyerTel : '-'}</td>
                  <td>{dayjs(e.salesDate).format('YYYY.MM.DD HH:mm')}</td>
                  <td>{e.color}</td>
                  <td>{e.carDTO.modelName}</td>
                  <td>{e.carDTO.price.toLocaleString() + '원'}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default SalesInfoList