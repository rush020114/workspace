import React, { useEffect, useState } from 'react'
import styles from './CartList.module.css'
import { useParams } from 'react-router-dom'
import axios from 'axios';
import dayjs from 'dayjs';
import Input from '../common/Input';
import Button from '../common/Button'

const CartList = () => {

  // 로그인한 사용자 정보 받아오기
  const loginInfo = sessionStorage.getItem('loginInfo');

  // 로그인한 사용자 정보 객체 풀어주기
  const loginData = JSON.parse(loginInfo);

  // 조회한 장바구니 목록을 저장할 state변수
  const [cartList, setCartList] = useState([]);

  // 장바구니 목록을 조회할 useEffect
  useEffect(() => {
    axios.get(`/api/carts/${loginData.memId}`)
    .then(res => setCartList(res.data))
    .catch(e => console.log(e));
  }, []);


  console.log(cartList)
  // 총 가격
  let totalPrice = 0;
  if(cartList.length !== 0){
    for(let i = 0 ; i < cartList.length ; i++){
      totalPrice += parseInt(cartList[i].totalPrice)
    }
  }

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
            <td>
              <input type="checkbox" checked/>
            </td>
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
            cartList.map((cart, i) => {
              return(
                <tr key={i}>
                  <td>
                    <input type="checkbox" checked/>
                  </td>
                  <td>
                    <p>{cartList.length - i}</p>
                  </td>
                  <td>
                    <div className={styles.img_div}>
                      <div><img src="./부동상 상식사전_메인.jpg" /></div>
                      <p>{cart.bookDTO.title}</p>
                    </div>
                  </td>
                  <td>{cart && parseInt(cart.bookDTO.price).toLocaleString()}</td>
                  <td>
                    <div className={styles.cnt_div}>
                      <Input 
                        type='number'
                        value={cart.cartCnt}
                      />
                      <Button 
                        title='수량변경'
                        color='green'
                      />
                    </div>
                  </td>
                  <td>{cart && parseInt(cart.totalPrice).toLocaleString()}</td>
                  <td>{dayjs(cart.cartDate).format('YYYY.MM.DD HH:mm')}</td>
                  <td><Button title='삭제' color='gray' /></td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
      <div className={styles.totalPrice}>
        <div>
          <div><p>구매가격</p></div>
          <div><p>{totalPrice.toLocaleString()}</p></div>
        </div>
        <Button 
          size='200px'
          padding='10px 0px'
          fontSize='1.2rem'
          title='선택 구매'
        />
      </div>
    </div>
  )
}

export default CartList