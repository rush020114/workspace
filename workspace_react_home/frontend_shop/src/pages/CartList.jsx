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

    // 체크박스 데이터를 저장할 state 변수
    // 체크 박스는 중복을 허용하므로 배열이 적합하다.
    const [checkboxesData, setCheckboxesData] = useState([]);
    
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
      .then(res => {
        setCartList(res.data);
        const checkboxArr = []
        for(const checkbox of res.data){
          checkboxArr.push(checkbox.cartNum);
        }
        setCheckboxesData(checkboxArr)
      })
      .catch(e => console.log(e));
    }, []);

    // 체크박스 값 변경 시 실행 함수
    const handleCheckboxes = e => {
      if(e.target.checked){
        setCheckboxesData([
          ...checkboxesData
          , parseInt(e.target.value)
        ])
      }
      else{
        setCheckboxesData(
          checkboxesData.filter(checkbox => checkbox !== parseInt(e.target.value))
        )
      }
    }

    console.log(checkboxesData)

    return (
      <div className={styles.container}>
        <table className={styles.table}>
          <colgroup>
            <col width='4%' />
            <col width='4%' />
            <col width='32%' />
            <col width='10%' />
            <col width='20%' />
            <col width='10%' />
            <col width='12%' />
            <col width='8%' />
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
                      <input 
                        // checkbox의 value도 하나하나씩 구별할 수 있는 데이터를 넣어주어야 한다.
                        // 장바구니를 하나하나 구분지을 수 있는 것은 pk가 적합하다.
                        // value를 나중에 등록 데이터로 사용할 것이니 pk를 쓰면 구별이 된다.
                        type="checkbox" 
                        value={cart.cartNum}
                        checked={checkboxesData.includes(cart.cartNum)}
                        onChange={e => handleCheckboxes(e)}
                      />
                    </td>
                    <td>{cartList.length - i}</td>
                    <td>
                      <div className={styles.img_div}>
                        <div>
                          <img src={`http://localhost:8080/upload/${cart.bookDTO.bookImgDTOList[0].attachedImgName}`} />
                        </div>
                        <p>{cart.bookDTO.title}</p>
                      </div>
                    </td>
                    <td>{cart && parseInt(cart.bookDTO.price).toLocaleString()}</td>
                    <td>
                      <div className={styles.cnt_div}>
                        <Input 
                          value={cart.cartCnt}
                        />
                        <Button
                          title='수 정' 
                          size='60px'
                          color='green'
                        />
                      </div>
                    </td>
                    <td>{cart && parseInt(cart.totalPrice).toLocaleString()}</td>
                    <td>{dayjs(cart.cartDate).format('YYYY.MM.DD HH:mm')}</td>
                    <td>
                      <Button 
                        title='삭 제' 
                        size='60px'
                        color='gray'
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
                >장바구니 목록이 없습니다.</td>
              </tr>
            }
          </tbody>
        </table>
        <div className={styles.totalPrice}>
          <div>
            <div><p>구매가격</p></div>
            <div><p></p></div>
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