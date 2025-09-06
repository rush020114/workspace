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
        nav('/user/cart-list');
      })
      .catch();
    }
    else{
      alert('로그인 후 이용해주십시오.')
    };
  };

  // 상품 구매
  const buyInDetail = () => {
    if(loginInfo){
      axios.post('/api/buys', {
        clothingNum: clothingNum
        , memId: loginData.memId
        , buyCnt: cnt
      })
      .then(res => {
        alert('주문완료');
        nav('/')
      })
      .catch(e => console.log(e));
    }
    else{
      alert('로그인 후 이용해주십시오.')
    };
  };

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.left_content}>
          {
            clothingDetail.clothingImgDTOList
            &&
            clothingDetail.clothingImgDTOList.map((img, i) => {
              if(img.isMain === 'Y'){
                return(
                  <img 
                    key={i}
                    src={`http://localhost:8080/upload/${img.attachedImgName}`} 
                  />
                )
              }
            })
          }
        </div>
        <div className={styles.right_content}>
          <div>
            <p>{clothingDetail.clothingName}</p>
            <p>{clothingDetail.brand}</p>
            <p>
              {clothingDetail.price && parseInt(clothingDetail.price).toLocaleString() + '원'}
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
               총가격 : {clothingDetail.price && parseInt(clothingDetail.price * cnt).toLocaleString() + '원'}
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
              onClick={() => buyInDetail()}
            />
          </div>
        </div>
      </div>
      <div className={styles.intro}>
        <div className={styles.intro_div}>
          <PageTitle 
            fontSize='2.5rem'
            size='300px'
            title='상품 소개'
          />
          <div>{clothingDetail.clothingIntro}</div>
        </div>
        <div className={styles.detail_img}>
          {
            clothingDetail.clothingImgDTOList
            &&
            clothingDetail.clothingImgDTOList.map((img, i) => {
              if(img.isMain === 'N'){
                return(
                  <img 
                    key={i}
                    src={`http://localhost:8080/upload/${img.attachedImgName}`} 
                  />
                )
              }
            })
          }
        </div>
      </div>
    </div>
  )
}

export default ClothingDetail