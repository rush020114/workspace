import axios from 'axios';
import React, { useEffect, useState } from 'react'
import './OrderList.css'

const OrderList = () => {
  const [orderList, setOrderList] = useState([]);

  useEffect(() => {
    axios.get('/api/orders')
    .then((res) => {
      console.log(res.data)
      setOrderList(res.data)
    })
    .catch((error) => {console.log(error)})
  }, [])

  return (
    <div className='orderList_container'>
      <h1>주 문 목 록</h1>
      <table>
        <colgroup>
          <col width='10%'/>
          <col width='*'/>
          <col width='20%'/>
          <col width='20%'/>
          <col width='20%'/>
        </colgroup>
        <thead>
          <tr>
            <td>No</td>
            <td>상품명</td>
            <td>상품가격</td>
            <td>수량</td>
            <td>총가격</td>
          </tr>
        </thead>
        <tbody>
          {
            orderList.map((order, i) => {
              return(
                <tr key={i}>
                  <td>{orderList.length - i}</td>
                  <td>{order.itemName}</td>
                  <td>{order.itemPrice}원</td>
                  <td>{order.itemCnt}</td>
                  <td>{order.itemPrice * order.itemCnt}원</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default OrderList
