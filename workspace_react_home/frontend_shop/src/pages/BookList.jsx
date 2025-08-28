import React, { useEffect, useState } from 'react'
import styles from './BookList.module.css'
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

// pages 폴더는 우리가 보는 화면 하나하나를 넣는다.
const BookList = () => {

  const nav = useNavigate();

  // 도서 목록 조회를 저장할 state변수
  const [bookList, setBookList] = useState([]);

  // 도서 목록을 조회할 useEffect
  useEffect(() => {
    axios('/api/books')
    .then(res => setBookList(res.data))
    .catch(e => console.log(e));
  }, []);

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        {
          bookList.map((book, i) => {
            return(
              <div key={i} className={styles.list_div}>
                <div className={styles.img_div}>
                  <img
                    onClick={() => nav(`/book-detail/${book.bookNum}`)}
                    src={`http://localhost:8080/upload/${book.bookImgDTOList[0].attachedImgName}`}
                  />
                </div>
                <div className={styles.info}>
                  <p>{book.title}</p>
                  <p>{book.price.toLocaleString()}</p>
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