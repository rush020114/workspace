import React, { useEffect, useState } from 'react'
import styles from './ManageCar.module.css'
import Select from '../common/Select'
import Input from '../common/Input'
import Button from '../common/Button'
import axios from 'axios'

const ManageCar = () => {

  // 등록 시 리렌더링을 도와줄 state 변수
  const [reload, setReload] = useState(0);

  // 치량 목록을 조회할 state 변수
  const [carList, setCarList] = useState([]);

  // 유효성 검사 상태 문자를 저장할 state 변수
  const [errorMsg, setErrorMsg] = useState({
    carMaker: ''
    , modelName: ''
    , price: ''
  })

  // 버튼 비활성화를 상태를 저장할 state 변수
  const [isDisable, setIsDisable] = useState(true);

  // 차량 등록 데이터를 저장할 state 변수
  const [carData, setCarData] = useState({
    carMaker: ''
    , modelName: ''
    , price: ''
  });

  // 차량 등록 값을 세팅할 함수
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

  // 버튼 비활성화 여부를 결정할 useEffect
  useEffect(() => {
    if(!carData.carMaker ||
      !carData.modelName ||
      !carData.price
    ){
      setIsDisable(true)
    }
    else{
      setIsDisable(false)
    }
  }, [carData]);

  // 차량을 등록할 함수
  const regCar = () => {
    axios.post('/api/cars', carData)
    .then(res => {
      setCarData({
        carMaker: ''
        , modelName: ''
        , price: ''
      });
      alert('등록완료');
      setReload(reload + 1);
    })
    .catch();
  };

  // 차량 목록을 조회할 useEffect
  useEffect(() => {
    axios.get('/api/cars')
    .then(res => setCarList(res.data))
    .catch(e => console.log(e));
  }, [reload]);

  return (
    <div className={styles.container}>
      <div className={styles.regCar}>
        <div>
          <h2>차량 등록</h2>
        </div>
        <div>
          <div>
            <p>제조사</p>
            <Select
              name='carMaker'
              value={carData.carMaker}
              onChange={e => {
                handleCarData(e);
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
              name='modelName'
              value={carData.modelName}
              onChange={e => {
                handleCarData(e);
                setErrorMsg({
                  ...errorMsg
                  , modelName: e.target.value ? '' : '모델명은 필수입력입니다.'
                });
              }}
            />
            <p className='error'>{errorMsg.modelName}</p>
          </div>
          <div>
            <p>차량가격</p>
            <Input 
              name='price'
              value={carData.price ? parseInt(carData.price).toLocaleString() : ''}
              onChange={e => {
                handleCarData(e);
                setErrorMsg({
                  ...errorMsg
                  , price: e.target.value ? '' : '가격은 필수입력입니다.'
                })
              }}
            />
            <p className='error'>{errorMsg.price}</p>
          </div>
        </div>
        <div>
          <Button 
            title='등 록'
            onClick={() => regCar()}
            disabled={isDisable}
          />   
        </div>
      </div>
      <div className={styles.carList}>
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
                carList.map((car, i) => {
                  return(
                    <tr>
                      <td>{carList.length - i}</td>
                      <td>{car.modelNum}</td>
                      <td>{car.modelName}</td>
                      <td>{car.carMaker}</td>
                    </tr>
                  )
                })
              }
            </tbody>
          </table>
        </div>
      </div>
    </div>
  )
}

export default ManageCar