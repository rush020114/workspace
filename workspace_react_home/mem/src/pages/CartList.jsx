import React, { useEffect, useRef, useState } from 'react'
import styles from './CartList.module.css'
import axios from 'axios';
import Button from '../common/Button'
import Input from '../common/Input'
import dayjs from 'dayjs';
import { useNavigate } from 'react-router-dom';

const CartList = () => {

  const nav = useNavigate();

  // db데이터 변경 시 화면 반영을 도와줄 useState
  const [reload, setReload] = useState(0);
  
  // 장바구니 목록을 저장할 state 변수
  const [cartList, setCartList] = useState([]);

  // 체크박스 데이터를 저장할 state변수
  const [checkboxes, setCheckboxes] = useState([]);

  // 전체 체크박스 체크 데이터들을 저장할 useRef
  const checkboxArr = useRef([]);

  // 최종가격을 저장할 state 변수
  const [finalPrice, setFinalPrice] = useState(0);

  // 전체 체크박스 체크 최종가격을 저장할 useRef
  const allCheckboxPrice = useRef(0); 
  
  // 장바구니 목록을 세팅할 useEffect
  useEffect(() => {
    
    // 로그인 정보 조회
    const loginInfo = sessionStorage.getItem('loginInfo');

    if(!loginInfo){
      alert('접근권한이 없습니다.');
      nav('/')
      return;
    }
  
    // 로그인 정보 객체화
    const loginData =  JSON.parse(loginInfo);

    axios.get(`/api/carts/${loginData.memId}`)
    .then(res => {
      setCartList(res.data)
      checkboxArr.current = [];
      allCheckboxPrice.current = 0;

      for(const cart of res.data){
        checkboxArr.current.push(cart.cartNum);
        allCheckboxPrice.current += cart.totalPrice;
      };
      setCheckboxes(checkboxArr.current);
      setFinalPrice(allCheckboxPrice.current);
    })
    .catch(e => console.log(e));
  }, [reload]);

  // 장바구니 각각의 체크박스들 체크박스 체크 여부 결정 함수
  const handleCheckbox = e =>{
    if(e.target.checked){
      setCheckboxes([
        ...checkboxes
        , parseInt(e.target.value)
      ]);
    }
    else{
      setCheckboxes(checkboxes.filter(checkbox => checkbox !== parseInt(e.target.value)));
    };
  };

  // 최종 가격 세팅 함수
  const handleFinalPrice = (e, totalPrice) => {
    e.target.name === 'checkAll'
    ?
    setFinalPrice(e.target.checked ? allCheckboxPrice.current : 0)
    :
    setFinalPrice(e.target.checked ? finalPrice + totalPrice : finalPrice - totalPrice)
  }

  // 장바구니 삭제
  const deleteCart = cart => {
    confirm('삭제하시겠습니까?')
    &&
    axios.delete(`/api/carts/${cart.cartNum}`)
    .then(res => setReload(reload + 1))
    .catch(e => console.log(e));
  };

  // 장바구니 수량 수정
  const updateCartCnt = (e, cart) => {
    axios.put(`/api/carts/${cart.cartNum}`, {
      cartCnt: e.target.value
      , clothingNum: cart.clothingNum
    })
    .then(res => setReload(reload + 1))
    .catch();
  };

  // 장바구니 선택 구매 
  const buyInCart = () => {
    axios.post('/api/buys/cart-buy', {cartNumList: checkboxes})
    .then(res => {
      alert('주문완료');
      setReload(reload + 1);
    })
    .catch(e => console.log(e));
  };

  console.log(cartList)
  console.log(checkboxes);
  console.log(finalPrice);

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
              <input type="checkbox" 
                name='checkAll'
                checked={checkboxArr.current.length === checkboxes.length}
                onChange={e => {
                  setCheckboxes(e.target.checked ? checkboxArr.current : []);
                  handleFinalPrice(e);
                }}
              />
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
                    <input type="checkbox" 
                      name='checkSingle'
                      value={cart.cartNum}
                      checked={checkboxes.includes(cart.cartNum)}
                      onChange={e => {
                        handleCheckbox(e)
                        handleFinalPrice(e, cart.totalPrice)
                      }}
                    />
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
                  <td>{cart.clothingDTO.price.toLocaleString() + '원'}</td>
                  <td>
                    <div className={styles.cnt_div}>
                      <Input
                        type='number'
                        size='120px'
                        min={1}
                        value={cart.cartCnt} 
                        onChange={e => updateCartCnt(e, cart)}
                      />
                    </div>
                  </td>
                  <td>{cart.totalPrice.toLocaleString() + '원'}</td>
                  <td>{dayjs(cart.cartDate).format('YYYY.MM.DD HH:mm')}</td>
                  <td>
                    <Button 
                      size='70px'
                      color='red'
                      content='삭 제'
                      onClick={e => deleteCart(cart)}
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
          <div><p>구매 가격</p></div>
          <div><p>{finalPrice.toLocaleString() + '원'}</p></div>
        </div>
        <Button 
          size='120px'
          color='blue'
          content='선택 구매'
          padding='12px 0px'
          onClick={() => buyInCart()}
        />
      </div>
    </div>
  )
}

export default CartList