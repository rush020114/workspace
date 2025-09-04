import React, { useEffect, useState } from 'react'
import styles from './ManageCar.module.css'
import Select from '../common/Select'
import Input from '../common/Input'
import Button from '../common/Button'
import axios from 'axios'

const ManageCar = () => {

  // 필수 데이터가 조건 미충족 시 버튼 비활성화를 결정할 state 변수
  const [isDisable, setIsDisable] = useState(true);

  // 유효성 검사 결과를 나타낼 문자를 저장할 state 변수
  const [errorMsg, setErrorMsg] = useState({
    carMaker: ''
    , modelName: ''
    , price: ''
  });

  // 조회된 차량 목록을 세팅할 state 변수
  const [carList, setCarList] = useState([]);

  // 차량 등록 데이터를 저장할 state변수
  const [carData, setCarData] = useState({
    carMaker: ''
    , modelName: ''
    , price: ''
  });

  // 차량 등록 데이터를 세팅할 함수
  const handleCarData = e => {
    setCarData({
      ...carData
      , [e.target.name]: e.target.name === 'price'
                        ?
                        e.target.value.replaceAll(',', '')
                        :
                        e.target.value 
    });
  };

  // 차량을 조회할 useEffect
  useEffect(() => {
    axios.get('/api/cars')
    .then(res => setCarList(res.data))
    .catch(e => console.log(e));
  }, [carData]);

  // 차량 등록 함수
  const regCar = () => {
    axios.post('/api/cars', carData)
    .then(res => {
      alert('등록완료');
      setCarData({
        carMaker: ''
        , modelName: ''
        , price: ''
      })
    })
    .catch(e => console.log(e));
  };

  // 버튼 비활성화 여부를 결정할 useEffect
  useEffect(() => {
    if(carData.carMaker &&
        carData.modelName &&
        carData.price 
    ){
      setIsDisable(false);
    }
    else{
      setIsDisable(true);
    }
  }, [carData])

  console.log(carData)
  return (
    <div className={styles.container}>
      <div className={styles.reg_car}>
        <div>
          <h1><span><i className="bi bi-car-front"></i></span> 차량 등록</h1>
        </div>
        <div className={styles.reg_content}>
          <div>
            <p>제조사</p>
            <Select
              name='carMaker'
              size='100%'
              value={carData.carMaker}
              onChange={e => {
                handleCarData(e)
                setErrorMsg({
                  ...errorMsg
                  , carMaker: e.target.value ? '' : '제조사를 선택해주세요.'
                });
              }}
            >
              <option value="">선택</option>
              <option value="현대">현대</option>
              <option value="기아">기아</option>
            </Select>
            <p className='error'>{errorMsg.carMaker}</p>
          </div>
          <div>
            <p>모델명</p>
            <Input
              size='100%'
              name='modelName'
              value={carData.modelName}
              onChange={e => {
                handleCarData(e)
                setErrorMsg({
                  ...errorMsg
                  , modelName: e.target.value ? '' : '모델명은 필수 입력입니다.'
                });
              }}
            />
            <p className='error'>{errorMsg.modelName}</p>
          </div>
          <div>
            <p>차량가격</p>
            <Input 
              size='100%'
              name='price'
              value={carData.price && parseInt(carData.price).toLocaleString()}
              onChange={e => {
                handleCarData(e)
                setErrorMsg({
                  ...errorMsg
                  , price: e.target.value ? '' : '가격은 필수 입력입니다.'
                });
              }}
            />
            <p className='error'>{errorMsg.price}</p>
          </div>
        </div>
        <div className={styles.btn_div}>
          <Button 
            onClick={() => regCar()}
            color='black'
            disabled={isDisable}
          />
        </div>
      </div>
      <div className={styles.carList}>
        <div>
          <h1><span><i className="bi bi-car-front"></i></span> 등록된 차량 목록</h1>
        </div>
        <table className={styles.table}>
          <colgroup>
            <col width={'25%'} />
            <col width={'25%'} />
            <col width={'25%'} />
            <col width={'25%'} />
          </colgroup>
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
              carList.length 
              ?
              carList.map((car, i) => {
                return(
                  <tr key={i}>
                    <td>{carList.length - i}</td>
                    <td>{car.modelNum}</td>
                    <td>{car.modelName}</td>
                    <td>{car.carMaker}</td>
                  </tr>
                )
              })
              :
              <tr>
                <td colSpan={4}>조회된 목록이 없습니다.</td>
              </tr>
            }
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default ManageCar