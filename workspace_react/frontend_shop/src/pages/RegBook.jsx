import React, { useEffect, useState } from 'react'
import styles from './RegBook.module.css'
import Select from '../common/Select'
import Input from '../common/Input'
import Button from '../common/Button'
import Textarea from '../common/Textarea'
import axios from 'axios'
import { handleRegBookErrorMsg } from '../validate/RegBookValidate'
import PageTitle from '../common/PageTitle'

const RegBook = () => {

  // 선택한 메인 이미지를 저장할 state 변수
  const [mainImg, setMainImg] = useState(null);

  // 선택한 서브 이미지를 저장할 state 변수
  const [subImgs, setSubImgs] = useState(null);

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
    , mainImg: ''
    , subImgs: ''
  });

  // 등록할 도서의 데이터를 저장할 state변수
  const [bookData, setBookData] = useState({
    cateNum: ''
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
      , [e.target.name]: e.target.name === 'price' 
                         ? 
                         e.target.value.replaceAll(',', '') 
                         : 
                         e.target.value    
    });
  };

  // 버튼 활성화를 결정해줄 useEffect
  useEffect(() => {
    if(bookData.cateNum !== '' && 
        bookData.title !== '' && 
        bookData.publisher !== '' && 
        bookData.price !== '' &&
        mainImg !== null &&
        subImgs !== null){
      setIsDisable(false);
    }
    else{
      setIsDisable(true);
    };
  }, [bookData, mainImg, subImgs]);

  // 도서등록 함수
  const regBook = () => {
    // 선택한 첨부파일 spring으로 가져가기
    // 업로드랑 등록이랑은 별개지만 등록과정에 포함되니 자바로 같이 보내준다.
    // 파일 데이터를 자바로 전송하기 위해서는 post함수의 3번째 매개변수를 활용해야 한다.

    // 전달되는 데이터에 파일 데이터도 포함되어 있습니다. 라는 정의
    const fileConfig = {'Content-Type': 'multipart/form-data'};

    // 파일 데이터가 포함된 내용을 자바로 전달할 때는 formData 객체를 사용해야 한다.
    // 1. formData 객체 생성
    // formData 객체에는 이미지뿐 아니라, 자바로 가져가는 모든 데이터를 저장한다.
    const formData = new FormData();
    // 선택한 메인 이미지를 formData에 추가
    formData.append('mainImg', mainImg);
    
    // 선택한 모든 서브 이미지들을 formData에 추가
    // 배열 자체를 전달 못하기 때문에 배열을 하나하나씩 전달한다.
    // key값만 동일하게 해주면 자바에서 알아서 배열 처리하여 subImgs에 저장한다.
    for(const subImg of subImgs){
      formData.append('subImgs', subImg);
    }

    // input 태그에 입력한 내용도 formData에 저장
    // input 태그에 입력한 모든 정보는 bookData 객체 안에 있음
    formData.append('cateNum', bookData.cateNum);
    formData.append('title', bookData.title);
    formData.append('publisher', bookData.publisher);
    formData.append('price', bookData.price);
    formData.append('bookIntro', bookData.bookIntro);

    axios.post('/api/books', formData, fileConfig)
    .then(res => {
      alert('등록성공');
      setBookData({
        cateNum: ''
        , title: ''
        , publisher: ''
        , price: ''
        , bookIntro: ''
      });
    })    
    .catch(e => console.log(e));

  };


  console.log(mainImg)
  console.log(subImgs)
  return (
    <div className={styles.container}>
      <div className={styles.title}>
        <PageTitle title='도서 등록' />
      </div>
      <div className={styles.content}>
        <div className={styles.content_div}>
          <div>
            <p>도서 카테고리</p>
            <Select
             size='100%'
             name='cateNum'
             value={bookData.cateNum}
             onChange={e => {
              handleBookData(e);
              setErrorMsg({
                ...errorMsg
                , cateNum: handleRegBookErrorMsg(e)
              });
             }}
            >
              <option value=''>선택</option>
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
            <p className='error'>{errorMsg.cateNum}</p>
          </div>
          <div>
            <p>도서명</p>
            <Input 
             size='100%'
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
            <p className='error'>{errorMsg.title}</p>
          </div>
          <div>
            <p>출판사</p>
            <Input 
             size='100%'
             name='publisher'
             value={bookData.publisher}
             onChange={e => {
              handleBookData(e)
              setErrorMsg({
                ...errorMsg
                , publisher: handleRegBookErrorMsg(e)
              })
             }}
            />
            <p className='error'>{errorMsg.publisher}</p>
          </div>
          <div>
            <p>가격</p>
            <Input 
             size='100%'
             name='price'
             value={
              bookData.price === '' ?
              bookData.price :
              parseInt(bookData.price).toLocaleString()
             }
             onChange={e => {
              handleBookData(e)
              setErrorMsg({
                ...errorMsg
                , price: handleRegBookErrorMsg(e)
              })
             }}
            />
          <p className='error'>{errorMsg.price}</p>
          </div>
          <div>
            <p>메인 페이지</p>
            <input
              type="file" 
              onChange={e => {
                // e.target.files -> 이벤트가 발생한 태그에서 선택한 파일들의 정보
                console.log(e.target.files);
                
                // 키 값에 정수를 적고 싶을 때도 []로 접근 가능하다.
                // 선택한 파일을 mainImg 변수에 저장
                setMainImg(e.target.files['0']);
                console.log(e.target.value)
                setErrorMsg({
                  ...errorMsg
                  , mainImg: !e.target.value ? '파일을 선택해주세요.' : ''
                })
              }}
            />
            <p className='error'>{errorMsg.mainImg}</p>
          </div>
          <div>
            <p>서브 페이지(다수 선택 가능)</p>
            {/* type='file'은 첨부파일 1개만 선택 가능, 다수 파일을 선택하려면 multiple={true} 속성 부여 */}
            <input
              type="file" 
              multiple={true} 
              onChange={e => {
                const fileArr = [];
                for(let i = 0 ; i < e.target.files.length ; i++){
                  fileArr.push(e.target.files[i])
                }
                setSubImgs(fileArr);
                setErrorMsg({
                  ...errorMsg
                  , subImgs: !e.target.value ? '파일을 선택해주세요.' : ''
                })
              }}
            />
            <p className='error'>{errorMsg.subImgs}</p>
          </div>
          <div>
            <p>도서 설명</p>
            <Textarea 
             size='100%'
             name='bookIntro'
             value={bookData.bookIntro}
             onChange={e => handleBookData(e)}
            ></Textarea>
          </div>
        </div>
        <div className={styles.btn}>
          <Button 
           title='등 록'
           onClick={() => regBook()}
           disabled={isDisable}
          />
        </div>
      </div>
    </div>
  )
}

export default RegBook