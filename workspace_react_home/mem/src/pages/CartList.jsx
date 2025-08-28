import React, { useEffect, useState } from 'react'
import styles from './CartList.module.css'
import axios from 'axios';
import Button from '../common/Button'
import Input from '../common/Input'
import dayjs from 'dayjs';

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
          <col width='3%' />
          <col width='3%' />
          <col width='34%' />
          <col width='10%' />
          <col width='20%' />
          <col width='10%' />
          <col width='10%' />
          <col width='10%' />
        </colgroup>
        <thead>
          <tr>
            <td>
              <input type="checkbox" />
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
            cartList.length
            ?
            cartList.map((cart, i) => {
              return(
                <tr key={i}>
                  <td>
                    <input type="checkbox" />
                  </td>
                  <td>{cartList.length - i}</td>
                  <td>
                    <div className={styles.img_div}>
                      <div>
                        <img
                          src={`http://localhost:8080/upload/${cart.clothingDTO.clothingImgDTOList[0].attachedImgName}`} 
                        />
                      </div>
                      <p>{cart.clothingDTO.clothingName}</p>
                    </div>
                  </td>
                  <td>{cart.clothingDTO.price.toLocaleString()}</td>
                  <td>
                    <div className={styles.cnt_div}>
                      <Input
                        type='number'
                        value={cart.cartCnt} 
                      />
                      <Button 
                        content='변 경'
                        color='green'
                        size='50px'
                      />
                    </div>
                  </td>
                  <td>{cart.totalPrice.toLocaleString()}</td>
                  <td>{dayjs(cart.cartDate).format('YYYY.MM.DD HH:mm') }</td>
                  <td>
                    <Button 
                      size='50px'
                      color='red'
                      content='삭 제'
                    />
                  </td>
                </tr>
              )
            })
            :
            <tr>
              <td
                colSpan={8}
                style={{padding: '50px 0px'}}
              >장바구니 목록이 존재하지 않습니다.</td>
            </tr>
          }
        </tbody>
      </table>
      <div className={styles.totalPrice}>
        <div>
          <div><p></p></div>
          <div><p></p></div>
        </div>
        <Button 
          color='blue'
        />
      </div>
    </div>
  )
}

export default CartList