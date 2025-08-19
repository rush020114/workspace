import React, { useEffect, useState } from 'react'
import styles from './RegBook.module.css'
import Select from '../common/Select'
import Input from '../common/Input'
import Button from '../common/Button'
import Textarea from '../common/Textarea'
import axios from 'axios'
import {handleRegBookErrorMsg } from '../validate/RegBookValidate'

const RegBook = () => {

  // 도서 카테고리 목록을 받을 state변수
  const [bookCategoryList, setBookCategoryList] = useState([]);

  // 도서등록 버튼 비활성화 state변수
  const [isDisable, setIsDisable] = useState(true);

  // 도서등록 유효성 검사 메시지 전달 state 변수
  const [errorMsg, setErrorMsg] = useState({
    cateNum: ''
    , title: ''
    , publisher: ''
    , price: ''
  })

  // 등록할 도서의 데이터를 저장할 state변수
  const [bookData, setBookData] = useState({
    cateNum: 0
    , title: ''
    , publisher: ''
    , price: ''
    , bookIntro: ''
  });

  // 도서 카테고리 목록을 조회할 useEffect
  useEffect(() => {
    axios.get('/api/book-categories')
    .then(res => setBookCategoryList(res.data))
    .catch(e => console.log(e));
  }, []);

  // 등록할 도서의 데이터를 세팅해줄 함수
  const handleBookData = e => {
    setBookData({
      ...bookData
      , [e.target.name]: e.target.value
    });
  };

  // 버튼 활성화를 결정해줄 if문
  useEffect(() => {
    if(bookData.cateNum !== 0 && bookData.title !== '' && bookData.publisher !== '' && bookData.price !== ''){
      setIsDisable(false);
    }
    else{
      setIsDisable(true);
    };
  }, [bookData]);

  // 도서등록 함수
  const regBook = () => {
    axios.post('/api/books', bookData)
    .then(res => {
      alert('등록성공')
      setBookData({
        cateNum: 0
        , title: ''
        , publisher: ''
        , price: ''
        , bookIntro: ''
      })
    })
    .catch(e => console.log(e))
  }

  console.log(bookData)
  console.log(errorMsg)
  return (
    <div className={styles.container}>
      <div className={styles.title}>
        <h2>도서등록</h2>
      </div>
      <div className={styles.content}>
        <div>
          <p>도서 카테고리</p>
          <Select
           name='cateNum'
           value={bookData.cateNum}
           onChange={e => {
            handleBookData(e)
            setErrorMsg({
              ...errorMsg
              , cateNum: handleRegBookErrorMsg(e)
            })
           }}
          >
            <option value={'0'}>선택</option>
            {
              bookCategoryList.map((bookCategory, i) => {
                return(
                  <option
                   key={i}
                   value={bookCategory.cateNum}
                  >{bookCategory.cateName}</option>
                )
              })
            }
          </Select>
          <p>{errorMsg.cateNum}</p>
        </div>
        <div>
          <p>도서명</p>
          <Input 
           name='title'
           value={bookData.title}
           onChange={e => {
            handleBookData(e)
            setErrorMsg({
              ...errorMsg
              , title: handleRegBookErrorMsg(e)
            })
           }}
          />
          <div>{errorMsg.title}</div>
        </div>
        <div>
          <p>출판사</p>
          <Input 
           name='publisher'
           value={bookData.publisher}
           onChange={e => handleBookData(e)}
          />
        </div>
        <div>
          <p>가격</p>
          <Input 
           name='price'
           value={bookData.price}
           onChange={e => handleBookData(e)}
          />
        </div>
        <div>
          <p>도서 설명</p>
          <Textarea 
           name='bookIntro'
           value={bookData.bookIntro}
           onChange={e => handleBookData(e)}
          ></Textarea>
        </div>
      </div>
      <div className={styles.btn}>
        <Button 
         onClick={() => regBook()}
         disabled={isDisable}
        />
      </div>
    </div>
  )
}

export default RegBook