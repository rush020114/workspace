  import React, { useEffect, useState } from 'react'
  import styles from './CartList.module.css'
  import axios from 'axios';
  import Button from '../common/Button';
  import Input from '../common/Input';
  import dayjs from 'dayjs';
import { useNavigate } from 'react-router-dom';

  const CartList = () => {

    const nav = useNavigate();

    // 장바구니 목록 조회를 저장할 state변수
    const [cartList, setCartList] = useState([]);
    
    // 장바구니 목록을 받아올 useEffect
    useEffect(() => {

      // 로그아웃을 위한 session저장공간 데이터 불러오는 변수
      const loginInfo = sessionStorage.getItem('loginInfo');
      
      if(!loginInfo){
        alert('접근 권한이 없습니다.');  
        nav('/')
        return;
      };

      // 저장된 로그인 정보의 객체화
      const loginData = JSON.parse(loginInfo);
      axios.get(`/api/carts/${loginData.memId}`)
      .then(res => setCartList(res.data))
      .catch(e => console.log(e));
    }, []);

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
                <input type="checkbox" />
              </td>
              <td>No</td>
              <td>상품명</td>
              <td>가격</td>
              <td>수량</td>
              <td>총가격</td>
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
                        <div><img src="차트분석 무작정 따라하기_메인.jpg" /></div>
                        <p>{cart.bookDTO.title}</p>
                      </div>
                    </td>
                    <td>{cart && parseInt(cart.bookDTO.price).toLocaleString()}</td>
                    <td>
                      <div className={styles.cnt_div}>
                        <Input 
                          value={cart.cartCnt}
                        />
                        <Button title='수정' />
                      </div>
                    </td>
                    <td>{cart && parseInt(cart.totalPrice).toLocaleString()}</td>
                    <td>{dayjs(cart.cartDate).format('YYYY.MM.SS HH:mm')}</td>
                    <td><Button title='삭제' /></td>
                  </tr>
                )
              })
              :
              <tr>
                <td
                  colSpan={8}
                  style={{padding: '50px 0px'}}
                >장바구니 목록이 없습니다.</td>
              </tr>
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