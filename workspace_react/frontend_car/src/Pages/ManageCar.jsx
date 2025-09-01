import React, { useEffect, useState } from 'react'
import styles from './ManageCar.module.css'
import Select from '../Common/Select'
import Input from '../Common/Input'
import Button from '../Common/Button'
import axios from 'axios'

const ManageCar = () => {

  // 조회된 차량 목록을 세팅할 state 변수
  const [carList, setCarList] = useState([]);

  // 차량 등록 데이터를 저장할 state변수
  const [carData, setCarData] = useState({
    modelName: ''
    , price: ''
    , carMaker: ''
  });

  // 차량 등록 데이터를 세팅할 함수
  const handleCarData = e => {
    setCarData({
      ...carData
      , [e.target.name]: e.target.value
    });
  };

  // 차량을 조회할 useEffect
  useEffect(() => {
    axios.get()
    .then()
    .catch(e => console.log(e));
  }, []);

  // 차량 등록 함수
  const regCar = () => {
    axios.post('/api/cars', carData)
    .then(res => {})
    .catch(e => console.log(e));
  };

  return (
    <div className={styles.container}>
      <div>
        <h2>차량 등록</h2>
        <div>
          <div>
            <p>제조사</p>
            <Select
              name='carMaker'
              value={''}
              onChange={e => handleCarData(e)}
            >
              <option value="">선택</option>
              <option value="현대">현대</option>
              <option value="기아">기아</option>
            </Select>
          </div>
          <div>
            <p>모델명</p>
            <Input 
              name='modelName'
              value={''}
              onChange={e => handleCarData(e)}
            />
          </div>
          <div>
            <p>차량가격</p>
            <Input 
              name='price'
              value={''}
              onChange={e => handleCarData(e)}
            />
          </div>
        </div>
        <div>
          <Button 
            onclick={() => regCar()}
          />
        </div>
      </div>
      <div>
        <h2>등록된 차량 목록</h2>
        <table>
          <thead>
            <tr>
              <td>No</td>
              <td>모델번호</td>
              <td>모델명</td>
              <td>제조사</td>
            </tr>
          </thead>
          <tbody>
            {
              carList.map((e, i) => {
                return(
                  <tr key={i}>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                  </tr>
                )
              })
            }
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default ManageCar