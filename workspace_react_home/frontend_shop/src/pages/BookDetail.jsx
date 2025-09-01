import React, { useEffect, useState } from 'react'
import styles from './BookDetail.module.css'
import Input from '../common/Input'
import Button from '../common/Button'
import PageTitle from '../common/PageTitle'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios'

const BookDetail = () => {

  const {bookNum} = useParams();

  const nav = useNavigate();

  // 로그아웃을 위한 session저장공간 데이터 불러오는 변수
  const loginInfo = sessionStorage.getItem('loginInfo');

  // 상품 수량 세팅 state 변수
  const [cnt, setCnt] = useState(1);

  // 도서 상세 조회 결과 저장할 state 변수
  const [bookDetail, setBookDetail] = useState({});

  // 도서 상세 조회해 올 useEffect
  useEffect(() => {
    axios.get(`/api/books/${bookNum}`)
    .then(res => setBookDetail(res.data))
    .catch(e => console.log(e));
  }, []);

  // 장바구니 등록 함수
  const regCartData = () => {
    if(loginInfo){
      axios.post('/api/carts', {
        bookNum: bookNum
        , cartCnt: cnt
        , memId: JSON.parse(loginInfo).memId
      })
      .then(res => {
        confirm('장바구니에 등록되었습니다.\n장바구니 목록으로 이동하시겠습니까?')
        &&
        nav('/user/cart-list ');
      })
      .catch(e => console.log(e));
    }
    else{
      alert('로그인 후 이용해주세요.')
    }
  };

  // 도서 구매
  const buyBook = () => {
    if(!loginInfo){
      alert('로그인 후 이용해주세요.')
      return;
    }
    axios.post(`/api/buys`, {
      bookNum: bookNum
      , memId: JSON.parse(loginInfo).memId
      , buyCnt: cnt
    })
    .then(res => alert('구매완료'))
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
                    src={`http://localhost:8080/upload/${bookDetail.bookImgDTOList[1].attachedImgName}`} 
                  />
                )
              }
            })
          }
        </div>
        <div className={styles.right_content}>
          <div>
            <p>{bookDetail.title}</p>
            <p>{bookDetail.publisher}</p>
            <p>{bookDetail.price && '￦' + bookDetail.price.toLocaleString()}</p>
            <Input 
              size='500px'
              fontSize='1.2rem'
              padding='16px'
              min='1'
              type='number'
              value={cnt}
              onChange={e => setCnt(e.target.value)}
            />
            <p>총가격 : ￦{bookDetail.price && (bookDetail.price  * cnt).toLocaleString()}</p>
          </div>
          <div className={styles.btn_div}>
            <Button 
              size='200px'
              padding='15px'
              fontSize='1.2rem'
              color='green'
              title='구매하기'
              onClick={() => buyBook()}
            />
            <Button 
              size='200px'
              padding='15px'
              fontSize='1.2rem'
              title='장바구니'
              onClick={() => regCartData()}
            />
          </div>
        </div>
      </div>
      <div className={styles.intro}>
        <div className={styles.intro_div}>
          <PageTitle
            fontSize='2.5rem'
            size='500px'
            title='도서 소개' 
          />
          <div>{bookDetail.bookIntro}</div>
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
                    src={`http://localhost:8080/upload/${bookDetail.bookImgDTOList[1].attachedImgName}`} 
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