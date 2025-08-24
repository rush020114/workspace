import axios from 'axios';
import styles from './ClothingDetail.module.css'
import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import Input from '../common/Input'
import Button from '../common/Button'
import PageTitle from '../common/PageTitle'

const ClothingDetail = () => {
  const nav = useNavigate();

  // 옷번호를 받을 useParams
  const {clothingNum} = useParams();

  // 로그인 데이터
  const loginInfo = sessionStorage.getItem('loginInfo');

  // 로그인 데이터 객체화
  const loginData = JSON.parse(loginInfo);

  // 옷 상세 정보를 저장할 state변수
  const [clothingDetail, setClothingDetail] = useState({});

  // 수량 세팅 state 변수
  const [cnt, setCnt] = useState(1);

  // 옷 상세 정보를 받아올 useEffect
  useEffect(() => {
    axios.get(`/api/clothes/${clothingNum}`)
    .then(res => setClothingDetail(res.data))
    .catch(e => console.log(e))
  }, []);

  // 장바구니 등록 함수
  const regCart = () => {
    if(loginInfo){
      axios.post('/api/carts', {
        clothingNum: clothingDetail.clothingNum
        , cartCnt: cnt
        , memId: loginData.memId
      })
      .then(res => {
        confirm('장바구니에 등록되었습니다. \n 장바구니 페이지로 이동하시겠습니까?')
        &&
        nav('/cart-list')
      })
      .catch();
    }
    else{
      alert('로그인 후 이용해주십시오.')
    }
  }

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.left_content}>
          <img src="../이글아이 워리어아머.png" />
        </div>
        <div className={styles.right_content}>
          <div>
            <p>{clothingDetail.clothingName}</p>
            <p>{clothingDetail.brand}</p>
            <p>
              {clothingDetail.price && parseInt(clothingDetail.price).toLocaleString()}
            </p>
            <Input 
              type='number'
              value={cnt}
              onChange={e => setCnt(e.target.value)}
              min='1'
              size='500px'
              padding='16px'
            />
            <p>
               총가격 : {clothingDetail.price && parseInt(clothingDetail.price * cnt).toLocaleString()}
            </p>
          </div>
          <div className={styles.btn_div}>
            <Button 
              size='200px'
              padding='12px'
              content='장바구니'
              fontSize='1.2rem'
              onClick={() => regCart()}
            />
            <Button 
              size='200px'
              padding='12px'
              content='구매하기'
              fontSize='1.2rem'
              color='blue'
            />
          </div>
        </div>
      </div>
      <div className={styles.intro}>
        <div className={styles.intro_div}>
          <PageTitle 
            fontSize='2.5rem'
            size='300px'
          />
          <div>{clothingDetail.clothingIntro}</div>
        </div>
        <div className={styles.detail_img}>
          <img src="../이글아이 워리어아머 상세정보.png" />
        </div>
      </div>
    </div>
  )
}

export default ClothingDetail