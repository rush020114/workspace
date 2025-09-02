import React, { useEffect, useState } from 'react'
import styles from './RegSalesInfo.module.css'
import Select from '../common/Select'
import Input from '../common/Input'
import Button from '../common/Button'
import axios from 'axios'

const RegSalesInfo = () => {

  const telRegex = /^\d{3}-\d{4}-\d{4}$/;

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
    axios.post()
    .then(res => {
      alert('등록완료')
    })
    .catch(e => console.log(e));
  };

  return (
    <div className={styles.container}>
      <div className={styles.content}>
        <div>
          <p>구매자명</p>
          <Input />
        </div>
        <div>
          <p>색상</p>
          <Select>
            <option value="">선택</option>
            <option value="화이트">화이트</option>
            <option value="블랙">블랙</option>
            <option value="레드">레드</option>
          </Select>
        </div>
        <div>
          <p>모델</p>
          <Select>
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
        </div>
        <div>
          <p>연락처</p>
          <Input />
        </div>
      </div>
      <div>
        <Button />
      </div>
    </div>
  )
}

export default RegSalesInfo