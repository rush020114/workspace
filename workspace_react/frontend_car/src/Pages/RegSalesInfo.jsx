import React, { useEffect, useState } from 'react'
import styles from './RegSalesInfo.module.css'
import Select from '../common/Select'
import Input from '../common/Input'
import Button from '../common/Button'
import axios from 'axios'

const RegSalesInfo = () => {

  // 차모델명(차번호)을 조회하기 위한 state변수
  const [] =  useState([]);

  // 판매등록을 할 데이터를 저장하기 위한 state 변수
  const [salesData, setSalesData] = useState({
    buyer: ''
    , color: ''
    , modelNum: ''

  })

  // 모델명을 조회할 useEffect
  useEffect(() => {
    axios.get()
    .then(res => setCarList(res.data))
    .catch(e => console.log(e));
  }, []);

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
              carList.map(() => {
                return(
                  <option 
                    key={i}
                    value={}
                  >{}</option>
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