import React, { useEffect, useState } from 'react'
import styles from './RegSalesInfo.module.css'
import Select from '../common/Select'
import Input from '../common/Input'
import Button from '../common/Button'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const RegSalesInfo = () => {

  const nav = useNavigate();

  // 버튼 활성화 여부를 저장할 state변수
  const [isDisable, setIsDisable] = useState(true);

  // XXX-XXXX-XXXX 형식의 전화번호 정규식
  const buyerTelRegex = /^\d{3}-\d{4}-\d{4}$/;

  // 유효성 검사 상태문자를 저장하기 위한 state 변수
  const [errorMsg, setErrorMsg] = useState({
    buyer: ''
    , color: ''
    , modelNum: ''
    , buyerTel: ''
  })

  // 차모델명(차번호)을 조회하기 위한 state변수
  const [carList, setCarList] =  useState([]);

  // 판매등록을 할 데이터를 저장하기 위한 state 변수
  const [salesData, setSalesData] = useState({
    buyer: ''
    , color: ''
    , modelNum: ''
    , buyerTel: ''
  });

  // 모델명을 조회할 useEffect
  useEffect(() => {
    axios.get('/api/cars')
    .then(res => setCarList(res.data))
    .catch(e => console.log(e));
  }, []);

  // 판매등록 할 데이터를 세팅하기 위한 함수
  const handleSalesDate = e => {
    setSalesData({
      ...salesData
      , [e.target.name]: e.target.value
    });
  };

  // 전화번호 유효성 검사
  const handleBuyerTelErrorMsg = e => {

    // 에러 메시지를 저장할 변수
    let errorStr = '';

    if(!e.target.value){
      errorStr = '';
    }
    else if(!buyerTelRegex.test(e.target.value)){
      errorStr = '전화번호의 형식은 XXX-XXXX-XXXX입니다.'
    }

    return errorStr;
  };

  // 버튼 활성화 여부를 결정할 useEffect
  // 구매자명, 색상, 모델명 중 하나라도 입력되지 않으면 버튼 비활성화
  // 위 조건을 충족하더라도 전화번호 형식이 맞지 않다면 비활성화지만 
  // 전화번호에 아무것도 입력하지 않으면 활성화
  useEffect(() => {
    if(!salesData.buyer ||
      !salesData.color ||
      !salesData.modelNum ||
      !buyerTelRegex.test(salesData.buyerTel) &&
      salesData.buyerTel
    ){
      setIsDisable(true);
    }
    else{
      setIsDisable(false);
    };
  }, [salesData]);

  // 판매정보를 등록할 함수
  const regSalesInfo = () => {
    axios.post('/api/sales-infos', salesData)
    .then(res => {
      alert('등록완료')
      nav('/sales-info');
    })
    .catch(e => console.log(e));
  };
  console.log(carList)
  console.log(salesData)

  return (
    <div className={styles.container}>
      <h1><span><i className="bi bi-car-front"></i></span> 판매 정보 등록</h1>
      <div className={styles.content}>
        <div>
          <p>구매자명</p>
          <Input 
            size='100%'
            name='buyer'
            value={salesData.buyer}
            onChange={e => {
              handleSalesDate(e);
              setErrorMsg({
                ...errorMsg
                , buyer: e.target.value ? '' : '구매자명은 필수입력입니다.'
              });
            }}
          />
          <p className='error'>{errorMsg.buyer}</p>
        </div>
        <div>
          <p>연락처</p>
          <Input 
            size='100%'
            maxLength={13}
            name='buyerTel'
            value={salesData.buyerTel}
            onChange={e => {
              handleSalesDate(e);
              setErrorMsg({
                ...errorMsg,
                buyerTel: handleBuyerTelErrorMsg(e)
              });
            }}
          />
          <p className='error'>{errorMsg.buyerTel}</p>
        </div>
        <div>
          <p>색상</p>
          <Select
            size='100%'
            name='color'
            value={salesData.color}
            onChange={e => {
              handleSalesDate(e);
              setErrorMsg({
                ...errorMsg
                , color: e.target.value ? '' : '색상을 선택해주세요.'
              });
            }}
          >
            <option value="">선택</option>
            <option value="화이트">화이트</option>
            <option value="블랙">블랙</option>
            <option value="레드">레드</option>
          </Select>
          <p className='error'>{errorMsg.color}</p>
        </div>
        <div>
          <p>모델</p>
          <Select
            size='100%'
            name='modelNum'
            value={salesData.modelNum}
            onChange={e => {
              handleSalesDate(e);
              setErrorMsg({
                ...errorMsg
                , modelNum: e.target.value ? '' : '모델명을 선택해주세요.'
              });
            }}
          >
            <option value="">선택</option>
            {
              carList.map((car, i) => {
                return(
                  <option 
                    key={i}
                    value={car.modelNum}
                  >{car.modelName}</option>
                )
              })
            }
          </Select>
          <p className='error'>{errorMsg.modelNum}</p>
        </div>
      </div>
      <div className={styles.btn_div}>
        <Button 
          onClick={() => regSalesInfo()}
          color='black'
          disabled={isDisable}
        />
      </div>
    </div>
  )
}

export default RegSalesInfo