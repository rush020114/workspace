import React, { useEffect, useState } from 'react'
import styles from './CartList.module.css'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios';
import dayjs from 'dayjs';
import Input from '../common/Input';
import Button from '../common/Button'

const CartList = () => {
  const nav = useNavigate();
  
  // 조회한 장바구니 목록을 저장할 state변수
  const [cartList, setCartList] = useState([]);

  // 선택한 체크박스 값을 저장할 state 변수
  // 모든 체크박스가 선택된 채로 화면에 나오려면 조회한 모든 cartNum이 초기값으로 세팅되어야 함.
  const [checkData, setCheckData] = useState([]);
  
  // 장바구니 목록을 조회할 useEffect
  useEffect(() => {
    // 로그인한 사용자 정보 받아오기
    const loginInfo = sessionStorage.getItem('loginInfo');
    
    // 장바구니 페이지를 들어왔는데 만약 로그인이 되어 있지 않으면
    // 강제로 상품 목록 페이지로 이동
    if(!loginInfo){
      nav('/');
      alert('접근 권한이 없습니다.');
      return;
    };
    // 로그인한 사용자 정보 객체화(JSON 데이터)
    const loginData = JSON.parse(loginInfo);

    axios.get(`/api/carts/${loginData.memId}`)
    .then(res => {
      setCartList(res.data);
      // 체크박스 초기값 세팅
      const checkboxDataArr = [];
      for(const e of res.data){
        checkboxDataArr.push(e.cartNum);
      }
      setCheckData(checkboxDataArr);
    })
    .catch(e => console.log(e));
  }, []);

  // 체크박스 값 변경 시 실행 함수
  const handleCheckbox = e => {
    // 체크가 됐다면...
    // cartNum을 숫자로 변환해서 저장
    if(e.target.checked){
      setCheckData([
        ...checkData
        , parseInt(e.target.value)
      ])
    }
    // 체크가 해제됐다면
    else{
      setCheckData(checkData.filter(cartNum => cartNum !== parseInt(e.target.value)))
    }
  }

  console.log(checkData)

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
              <input
                type="checkbox" 
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
                    <input
                      type="checkbox" 
                      checked={checkData.includes(cart.cartNum)}
                      value={cart.cartNum}
                      onChange={e => handleCheckbox(e)}
                    />
                  </td>
                  <td>
                    <p>{cartList.length - i}</p>
                  </td>
                  <td>
                    <div className={styles.img_div}>
                      <div>
                        <img
                          src={`http://localhost:8080/upload/${cart.bookDTO.bookImgDTOList[0].attachedImgName}`} 
                        />
                      </div>
                      <p>{cart.bookDTO.title}</p>
                    </div>
                  </td>
                  <td>{cart.bookDTO.price.toLocaleString()}</td>
                  <td>
                    <div className={styles.cnt_div}>
                      <Input 
                        type='number'
                        value={cart.cartCnt}
                      />
                      <Button 
                        title='변 경'
                        color='green'
                      />
                    </div>
                  </td>
                  <td>{cart.totalPrice.toLocaleString()}</td>
                  <td>{dayjs(cart.cartDate).format('YYYY.MM.DD HH:mm')}</td>
                  <td><Button title='삭 제' color='gray' /></td>
                </tr>
              )
            })
            :
            <tr>
              <td 
                colSpan={8}
                style={{padding: '50px 0px'}}
              >장바구니에 담은 도서가 없습니다.</td>
            </tr>
          }
        </tbody>
      </table>
      <div className={styles.totalPrice}>
        <div>
          <div><p>구매가격</p></div>
          <div><p>{}</p></div>
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