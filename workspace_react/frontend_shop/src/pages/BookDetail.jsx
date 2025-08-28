import React, { useEffect, useState } from 'react'
import styles from './BookDetail.module.css'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios';
import Button from '../common/Button'
import Input from '../common/Input'
import PageTitle from '../common/PageTitle'

const BookDetail = () => {

  const nav = useNavigate();

  // 도서 상세 페이지 번호를 url로 받을 params
  const {bookNum} = useParams();

  // 로그인 정보
  const loginInfo = sessionStorage.getItem('loginInfo');
  
  // 로그인 정보 사용을 위한 변수
  const loginData = JSON.parse(loginInfo);

  // 상품 수량 세팅 state변수
  const [inputNumber, setInputNumber] = useState(1);
  
  // 도서 상세 정보를 받아올 state변수
  const [bookDetail, setBookDetail] = useState({});
  
  // 도서 상세 정보를 조회할 useEffect
  useEffect(() => {
    axios.get(`/api/books/${bookNum}`)
    .then(res => setBookDetail(res.data))
    .catch(e => console.log(e))
  }, []);

  // 장바구니 등록 함수
  const regCartData = () => {
    // 로그인 안했으면
    if(!sessionStorage.getItem('loginInfo')){
      alert('장바구니를 이용하려면 로그인하셔야 합니다.');
      return;
    }
    axios.post('/api/carts', {bookNum: bookNum, cartCnt: inputNumber, memId: loginData.memId})
    .then(res => {
      confirm('장바구니에 상품을 담았습니다.\n장바구니 페이지로 이동할까요?')
      &&
      nav('/user/cart-list');
    })
    .catch(e => console.log(e));
  };

  console.log(bookDetail)
  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.left_content}>
          {
            bookDetail.bookImgDTOList
            &&
            bookDetail.bookImgDTOList.map((img, i) => {
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
          <table className={styles.content_table}>
            <colgroup>
              <col width='35%' />
              <col width='65%' />
            </colgroup>
            <thead>
              <tr>
                <td>책이름</td>
                <td>{bookDetail.title}</td>
              </tr>
              <tr>
                <td>출판사</td>
                <td>{bookDetail.publisher}</td>
              </tr>
              <tr>
                <td>가격</td>
                <td>{bookDetail.price && '￦' + bookDetail.price.toLocaleString()}</td>
              </tr>
              <tr>
                <td colSpan={2}>
                  <Input 
                    type='number'
                    padding='15px'
                    size='70%'
                    min='1'
                    value={inputNumber}
                    onChange={e => setInputNumber(e.target.value)}
                  />
                </td>
              </tr>
              <tr>
                <td>총 구매가격</td>
                <td>￦{bookDetail.price && (bookDetail.price * inputNumber).toLocaleString()}</td>
              </tr>
            </thead>
          </table>
          <div className={styles.btn_div}>
            <Button
              padding='12px 0px'
              size='200px'
              title='장바구니' 
              color='green' 
              fontSize='1.2rem'
              onClick={e => regCartData()}
            />
            <Button
              padding='12px 0px'
              size='200px' 
              title='구매하기'
              fontSize='1.2rem'
            />
          </div>
        </div>
      </div>
      <div className={styles.intro}>
        <div className={styles.intro_div}>
          <div>
            <PageTitle title='도서 소개' fontSize='2rem' />
            {bookDetail.bookIntro}
          </div>
        </div>
        <div className={styles.detail_img}>
          {
            bookDetail.bookImgDTOList
            &&
            bookDetail.bookImgDTOList.map((img, i) => {
              if(img.isMain !== 'Y'){
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

export default BookDetail