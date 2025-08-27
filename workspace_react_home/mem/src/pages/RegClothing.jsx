import React, { useEffect, useState } from 'react'
import styles from './RegClothing.module.css'
import PageTitle from '../common/PageTitle'
import Select from '../common/Select'
import Input from '../common/Input'
import Button from '../common/Button'
import Textarea from '../common/Textarea'
import axios from 'axios'

const RegClothes = () => {
  // 메인 이미지를 저장할 state 변수
  const [mainImg, setMainImg] = useState(null);

  // 서브 이미지들을 저장할 state 변수
  const [subImgs, setSubImgs] = useState(null);

  // 옷 카테고리 목록 조회를 받을 state변수
  const [cateList, setCateList] = useState([]);
  
  // 옷 등록 데이터 저장 state변수
  const [clothingData, setClothingData] = useState({
    cateNum: ''
    , clothingName: ''
    , brand: ''
    , price: ''
    , clothingIntro: ''
  });

  // 옷 등록 버튼 활성화 state 변수
  const [isDisable, setIsDisable] = useState(true);

  // 유효성 검사 메시지 state 변수
  const [errorMsg, setErrorMsg] = useState({
    cateNum: ''
    , clothingName: ''
    , brand: ''
    , price: ''
  })

  // 옷 카테고리 목록 조회 useEffect
  useEffect(() => {
    axios.get('/api/clothing-categories')
    .then(res => setCateList(res.data))
    .catch(e => console.log(e));
  }, []);

  // 옷 등록 값을 세팅할 함수
  const handleClothingData = e => {
    if(e.target.name === 'price'){
      setClothingData({
        ...clothingData
        , price: e.target.value.replaceAll(',', '')
      })
    }
    else{
      setClothingData({
        ...clothingData
        , [e.target.name]: e.target.value
      });
    };
  };

  // 버튼 활성화 조건 useEffect
  useEffect(() => {
    if(clothingData.cateNum 
      && clothingData.clothingName
      && clothingData.brand
      && clothingData.price
    ) setIsDisable(false)
    else setIsDisable(true)
  }, [clothingData]);

  // 옷 등록 함수
  const regClothingData = () => {

    const fileConfig = {'Content-Type': 'multipart/form-data'};

    const formData = new FormData();

    formData.append('mainImg', mainImg);
    for(const imgs of subImgs){
      formData.append('subImgs', imgs);
    };
    formData.append('cateNum', clothingData.cateNum);
    formData.append('clothingName', clothingData.clothingName);
    formData.append('brand', clothingData.brand);
    formData.append('price', clothingData.price);
    formData.append('clothingIntro', clothingData.clothingIntro);

    axios.post('/api/clothes',formData , fileConfig)
    .then(res => {
      alert('등록성공');
      setClothingData({
        cateNum: ''
        , clothingName: ''
        , brand: ''
        , price: ''
        , clothingIntro: ''
      })
    })
    .catch(e => console.log(e));
  };

  return (
    <div className={styles.container}>
      <div className={styles.title}>
        <PageTitle 
          title='옷 등록'
        />
      </div>
      <div className={styles.content}>
        <div className={styles.content_div}>
          <div>
            <p>옷 카테고리</p>
            <Select
              size='100%'
              name='cateNum'
              value={clothingData.cateNum}
              onChange={e => {
              handleClothingData(e);
                setErrorMsg({
                  ...errorMsg
                  , cateNum: !e.target.value ? '카테고리를 선택해주세요.' : ''
                });
              }}
            >
              <option value="">선택</option>
              {
                cateList.map((clothing, i) => {
                  return(
                    <option
                      key={i}
                      value={clothing.cateNum}
                    >{clothing.cateName}</option>
                  );
                })
              };
            </Select>
            <p className='error'>{errorMsg.cateNum}</p>
          </div>
          <div>
            <p>상품명</p>
            <Input 
              size='100%'
              name='clothingName'
              value={clothingData.clothingName}
              onChange={e => {
              handleClothingData(e);
                setErrorMsg({
                  ...errorMsg
                  , clothingName: !e.target.value ? '상품명은 필수입력입니다.' : ''
                });
              }}
            />
            <p className='error'>{errorMsg.clothingName}</p>
          </div>
          <div>
            <p>브랜드</p>
            <Input
              size='100%'
              name='brand'
              value={clothingData.brand}
              onChange={e => {
                handleClothingData(e);
                setErrorMsg({
                  ...errorMsg
                  , brand: !e.target.value ? '브랜드명은 필수입력입니다.' : ''
                });
              }}
            />
            <p className='error'>{errorMsg.brand}</p>
          </div>
          <div>
            <p>가격</p>
            <Input 
              size='100%'
              name='price'
              value={clothingData.price && parseInt(clothingData.price).toLocaleString()}
              onChange={e => {
                handleClothingData(e);
                setErrorMsg({
                  ...errorMsg
                  , price: !e.target.value ? '가격을 입력해주세요.' : ''
                });
              }}
            />
            <p className='error'>{errorMsg.price}</p>
          </div>
          <div>
            <p>메인이미지</p>
            <input
              type="file" 
              onChange={e => setMainImg(e.target.files[0])}
            />
          </div>
          <div>
            <p>서브이미지</p>
            <input 
              type="file" 
              multiple={true} 
              onChange={e => {
                const subImgArr = [];
                for(let i = 0 ; i < e.target.files.length ; i++){
                  subImgArr.push(e.target.files[0]);
                };
                setSubImgs(subImgArr);
              }}
            />
          </div>
          <div>
            <p>상품 소개</p>
            <Textarea 
              size='100%'
              name='clothingIntro'
              value={clothingData.clothingIntro}
              onChange={e => handleClothingData(e)}
            />
          </div>
        </div>
        <div className={styles.btn}>
          <Button 
            content='등 록'
            onClick={() => regClothingData()}
            disabled={isDisable}
          />
        </div>
      </div>
    </div>
  )
}

export default RegClothes