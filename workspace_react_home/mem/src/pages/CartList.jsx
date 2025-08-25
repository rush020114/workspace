import React, { useEffect, useState } from 'react'
import styles from './CartList.module.css'
import axios from 'axios';
import Button from '../common/Button'
import Input from '../common/Input'

const CartList = () => {

  // 로그인 정보 조회
  const loginInfo = sessionStorage.getItem('loginInfo');

  // 로그인 정보 객체화
  const loginData =  JSON.parse(loginInfo);

  // 장바구니 목록을 저장할 state 변수
  const [cartList, setCartList] = useState([]);

  // 장바구니 목록을 세팅할 useEffect
  useEffect(() => {
    axios.get(`/api/carts/${loginData.memId}`)
    .then(res => setCartList(res.data))
    .catch(e => console.log(e));
  }, []);

  console.log(cartList);

  return (
    <div className={styles.container}>
      <table className={styles.table}>
        <colgroup>
          <col width='5%' />
          <col width='5%' />
          <col width='25%' />
          <col width='10%' />
          <col width='20%' />
          <col width='10%' />
          <col width='15%' />
          <col width='10%' />
        </colgroup>
        <thead>
          <tr>
            <td></td>
            <td>No</td>
            <td>상품정보</td>
            <td>가격</td>
            <td>수량</td>
            <td>총 가격</td>
            <td>등록일</td>
            <td>삭제</td>
          </tr>
        </thead>
        <tbody>
          {
            cartList.map((e, i) => {
              return(
                <tr key={i}>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                  <td></td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
      <div className={styles.totalPrice}>
        <div>
          <div><p></p></div>
          <div><p></p></div>
        </div>
        <Button />
      </div>
    </div>
  )
}

export default CartList