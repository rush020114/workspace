import React, { useEffect, useState } from 'react'
import styles from './BookDetail.module.css'
import { useParams } from 'react-router-dom'
import axios from 'axios';
import Button from '../common/Button'

const BookDetail = () => {

  // 도서 상세 페이지 번호를 url로 받을 params
  const {bookNum} = useParams();
  console.log(bookNum)

  // 도서 상세 정보를 받아올 state변수
  const [bookDetail, setBookDetail] = useState({});

  // 도서 상세 정보를 조회할 useEffect
  useEffect(() => {
    axios.get(`/api/books/${bookNum}`)
    .then(res => setBookDetail(res.data))
    .catch()
  }, [])

  console.log(bookDetail)

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div className={styles.left_content}>
          <img src="../마인_메인.jpg"/>
        </div>
        <div className={styles.right_content}>
          <div>{bookDetail.bookNum}</div>
          <div>{bookDetail.title}</div>
          <div>{bookDetail.publisher}</div>
          <div>{bookDetail.price}</div>
          <div className={styles.btn_div}>
            <Button />
            <Button />
          </div>
        </div>
      </div>
      <div className={styles.intro}>
        <div>
          <div>{bookDetail.bookIntro}</div>
        </div>
        <div><img src="../마인_상세1.jpg"/></div>
      </div>
    </div>
  )
}

export default BookDetail