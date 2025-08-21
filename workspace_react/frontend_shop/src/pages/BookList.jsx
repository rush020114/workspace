import React, { useEffect, useState } from 'react'
import PageTitle from '../common/PageTitle'
import styles from './BookList.module.css'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const BookList = () => {

  const nav = useNavigate();

  // 도서 목록 조회 데이터를 받을 state변수
  const [bookList, setBookList] = useState([]);

  // 도서 목록을 받아올 useEffect
  useEffect(() => {
    axios.get('/api/books')
    .then(res => setBookList(res.data))
    .catch(e => console.log(e))
  }, [])

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        {
        bookList.map((book, i) => {
          return(
            <div key={i} className={styles.list_div}>
              <div className={styles.img_div}>
                <img src="./부동상 상식사전_메인.jpg" 
                 onClick={e => nav(`/book-detail/${book.bookNum}`)}
                />
              </div>
              <div className={styles.info}>
                <p>{book.title}</p>
                <p>￦{book.price.toLocaleString()}</p>
              </div>
            </div>
          )
        })
        }
      </div>
    </div>
  )
}

export default BookList