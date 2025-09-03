import React, { useEffect, useState } from 'react'
import styles from './RegSalesInfo.module.css'
import Select from '../common/Select'
import Input from '../common/Input'
import Button from '../common/Button'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'

const RegSalesInfo = () => {

  const nav = useNavigate();

  // 버튼 비활성화를 여부를 저장할 state 변수
  const [isDisable, setIsDisable] = useState(true);

  // 유효성 검사 상태 메시지를 저장할 state 변수
  const [errorMsg, setErrorMsg] = useState({
    buyer: ''
    , color: ''
    , modelNum: ''
    , buyerTel: ''
  });

  // XXX-XXXX-XXXX형태의 정규식
  const buyerTelRegex = /^\d{3}-\d{4}-\d{4}$/;

  // 차모델명을 받기 위해 차 정보 리스트를 저장할 state 변수
  const [carList, setCarList] = useState([]);

  // 차량판매정보 등록을 위한 데이터를 저장할 state 변수
  const [salesData, setSalesData] = useState({
    buyer: ''
    , color: ''
    , modelNum: ''
    , buyerTel: ''
  });

  // 차모델명을 받기 위해 차 정보 리스트를 세팅할 useEffect
  useEffect(() => {
    axios.get('/api/cars')
    .then(res => setCarList(res.data))
    .catch(e => console.log(e));
  }, []);

  // 차량 판매 정보 등록 데이터를 세팅해줄 함수
  const handleSalesData = e => {
    setSalesData({
      ...salesData
      , [e.target.name]: e.target.value
    });
  };

  // 차량 판매 등록 함수
  const regSalesInfo = () => {
    axios.post('/api/sales-infos', salesData)
    .then(res => {
      alert('등록완료');
      nav('/sales-info');
    })
    .catch(e => console.log(e));
  };

  // 버튼 활성화 여부를 결정할 useEffect
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

  console.log(salesData)

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div>
          <p>구매자명</p>
          <Input 
            name='buyer'
            value={salesData.buyer}
            onChange={e => {
              handleSalesData(e);
              setErrorMsg({
                ...errorMsg
                , buyer: e.target.value ? '' : '구매자명은 필수입력입니다.'
              })
            }}
          />
          <p className='error'>{errorMsg.buyer}</p>
        </div>
        <div>
          <p>색상</p>
          <Select
            name='color'
            value={salesData.color}
            onChange={e => {
              handleSalesData(e);
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
            name='modelNum'
            value={salesData.modelNum}
            onChange={e => {
              handleSalesData(e);
              setErrorMsg({
                ...errorMsg
                , modelNum: e.target.value ? '' : '모델을 선택해주세요.'
              })
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
        <div>
          <p>연락처</p>
          <Input 
            maxLength={13}
            name='buyerTel'
            value={salesData.buyerTel}
            onChange={e => {
              handleSalesData(e);
              setErrorMsg({
                ...errorMsg
                , buyerTel: buyerTelRegex.test(e.target.value) ? '' : '연락처의 형식은 XXX-XXXX-XXXX입니다.'
              })
            }}
          />
          <p className='error'>{errorMsg.buyerTel}</p>
        </div>
      </div>
      <div>
        <Button 
          title='등 록'
          onClick={() => regSalesInfo()}
          disabled={isDisable}
        />
      </div>
    </div>
  )
}

export default RegSalesInfo