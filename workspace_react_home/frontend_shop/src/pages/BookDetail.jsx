import React, { useEffect, useState } from 'react'
import styles from './BookDetail.module.css'
import Input from '../common/Input'
import Button from '../common/Button'
import PageTitle from '../common/PageTitle'
import { useParams } from 'react-router-dom'
import axios from 'axios'

const BookDetail = () => {

  const {bookNum} = useParams();

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

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.left_content}>
          <img src="../차트분석 무작정 따라하기_메인.jpg" />
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
            />
            <Button 
              size='200px'
              padding='15px'
              fontSize='1.2rem'
              title='장바구니'
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
          <img src="../차트분석 무작정 따라하기_상세1.jpg" />
        </div>
      </div>
    </div>
  )
}

export default BookDetail