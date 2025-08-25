import React, { useEffect, useState } from 'react'
import styles from './RegBook.module.css'
import PageTitle from '../common/PageTitle'
import Button from '../common/Button'
import Select from '../common/Select'
import Input from '../common/Input'
import Textarea from '../common/Textarea'
import axios from 'axios'


const RegBook = () => {

  // 선택한 파일을 저장할 state변수
  // 파일에 대한 형식은 문자열도 객체도 아닌 걸로 판단한다. 그래서 초기값을 null을 준다.(이미지는 문자열이 될 수 없는 데이터)
  const [mainImg, setMainImg] = useState(null);

  // 유효성 검사 결과 state변수
  const [errorMsg, setErrorMsg] = useState({
    cateNum: ''
    , title: ''
    , publisher: ''
    , price: ''
  })

  // 버튼 비활성화 결정 state변수
  const [isDisable, setIsDisable] = useState(true);

  // 도서 카테고리 목록을 저장할 state변수
  const [categoryList, setCategoryList] = useState([]);

  // 도서 등록 데이터 저장 state변수
  const [bookData, setBookData] = useState({
    cateNum: ''
    , title: ''
    , publisher: ''
    , price: ''
    , bookIntro: ''
  });

  // 도서 카테고리를 조회할 useEffect
  useEffect(() => {
    axios.get('/api/book-categories')
    .then(res => setCategoryList(res.data))
    .catch(e => console.log(e));
  }, []);

  // 도서 데이터 변경 함수
  const handleBookData = e => {
    setBookData({
      ...bookData
      // name속성이 price이면 replaceAll함수 실행
      // 현재 value로 넘어온 값이 toLocaleString이 적용되지 않으면 함수의 기능은 크게 의미 없음
      // value의 값이 1000을 넘어 ,가 붙으면 숫자형태로 변환
      , [e.target.name]: e.target.name === 'price'
                         ?
                         e.target.value.replaceAll(',', '') 
                         : 
                         e.target.value
    });
  };

  // 버튼 비활성화 결정 useEffect
  useEffect(() => {
    if(bookData.cateNum === '' ||
      bookData.title === '' ||
      bookData.publisher === '' ||
      bookData.price === ''
    ){
      setIsDisable(true);
    }
    else{
      setIsDisable(false);
    };
  }, [bookData]);

  // 도서 등록 함수
  const regBook = () => {

    // 업로드는 쿼리 실행은 아니지만 등록할 때 서버에 저장하므로 자바에는 보내야 한다.
    // 그래서 파일을 등록할 때 같이 보내주어 업로드해준다.
    // 파일 업로드(업로드란 client컴퓨터에서 보낸 파일을 server컴퓨터에 저장한다는 의미)

    // 파일을 자바로 보내기 위해선 post의 세번째 매개변수를 이용한다.
    // 보내는 데이터에 파일 데이터도 포함되어 있다는 정의
    const fileConfig = {'Content-Type': 'multipart/form-data'};

    // 원래 post의 두번째 매개변수는 객체를 전달하고 그 안의 내용은 문자열로 자바로 보내졌다.
    // 하지만 파일 자체를 보낼 때 이미지 등은 문자열이 될 수 없는 데이터이다.
    // 그래서 파일 데이터(숫자가 문자가 아니므로)가 포함될 때는 FormData 객체를 활용해야 한다.
    // append함수를 써서 formData에 데이터를 추가할 수 있는데 객체 형식(첫번째 매개변: key, 두번째 매개변수 value)처럼 값이 들어간다.
    const formData = new FormData();
    formData.append('mainImg', mainImg)

    axios.post('/api/books',formData , fileConfig)
    .then()
    .catch(e => console.log(e));

    // axios.post(`/api/books`, bookData)
    // .then(res => {
    //   alert('등록완료')
    //   setBookData({
    //     cateNum: ''
    //     , title: ''
    //     , publisher: ''
    //     , price: ''
    //     , bookIntro: ''
    //   })
    // })
    // .catch(e => console.log(e));
  };

  console.log(bookData)
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
                handleBookData(e)
                setErrorMsg({
                  ...errorMsg
                  , cateNum: !e.target.value ? '카테고리를 선택해주세요.' : ''
                })
              }}
              >
              <option value="">선택</option>
              {
                categoryList.map((category, i) => {
                  return(
                    <option
                    key={i}
                    value={category.cateNum}
                    >{category.cateName}</option>
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
                  , title: !e.target.value ? '제목은 필수 입력입니다.' : ''
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
                  , publisher: !e.target.value ? '출판사는 필수 입력입니다.' : ''
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
              // 숫자형태여야 parseInt가 실행되므로 replaceAll이 중요함
              // 숫자형태로 변환되어도 문자열이면 toLocaleString함수가 실행되지 않으므로
              // parseInt로 형변환을 시켜 value에 1000단위 ,가 붙어 화면에 반영
              // 값이 다시 변형되면 현재의 , 붙은 value값으로 onChange가 실행됨
              // 그리고 함수로 쉼표를 떼어주고 하는 ,를 다시 넣어주는 작업을 반복
              value={bookData.price === '' ? bookData.price : parseInt(bookData.price).toLocaleString()}
              onChange={e => {
                // price의 값이 입력되면 handleBookData함수 실행
                handleBookData(e)
                setErrorMsg({
                  ...errorMsg
                  , price: !e.target.value ? '가격은 필수 입력입니다.' : ''
                })
              }}
              />
            <p className='error'>{errorMsg.price}</p>
          </div>
          <div>
            <div>
              {/* type='file'은 파일을 첨부할 수 있는 폼요소이다. */}
              {/* onchange로 값을 저장할 수 있다. 형식은 e.target.files(이벤트가 발생한 태그의 파일들(객체))이다. */}
              {/* e.target.files의 키는 배열처럼 정수형식으로 되어 있어 []로 접근해야 한다. 그 안에 파일의 정보가 들어있다. */}
              <p>메인 이미지</p>
              <input 
                type="file" 
                onChange={e => setMainImg(e.target.files['0'])}
              />
            </div>
            <div>
              {/* multiple속성은 파일을 다수 선택할 수 있다. */}
              <p>서브 이미지(다수 선택 가능)</p>
              <input type="file" multiple={true} />
            </div>
          </div>
          <div>
            <p>도서 설명</p>
            <Textarea 
              size='100%'
              name='bookIntro'
              value={bookData.bookIntro}
              onChange={e => handleBookData(e)}
            />
          </div>
        </div>
        <div className={styles.btn}>
          <Button 
            onClick={e => {
              setBookData({
                cateNum: ''
                , title: ''
                , publisher: ''
                , price: ''
                , bookIntro: ''
              });
              regBook();
          }}
            disabled={isDisable}
          />
        </div>
      </div>
    </div>
  )
}

export default RegBook