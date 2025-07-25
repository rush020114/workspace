import axios from 'axios'
import React, { useState } from 'react'
import './FormPractice02.css'

const FormPractice02 = () => {

  const [deliveryInfo, setDeliveryInfo] = useState({
    chicken: '후라이드치킨',
    cnt: 1,
    addr: '',
    detail: '',
    request: ''
  })

  const handleDeliveryInfo = e => {
    setDeliveryInfo({
      ...deliveryInfo,
      [e.target.name]: e.target.value
    })
  } 

  const regDelivery = () => {
    axios.post('/api/deliverys', deliveryInfo)
    .then(res => console.log(res))
    .catch(error => console.log(error))
  }

  console.log(deliveryInfo)

  return (
    <div className='form2-container'>
      <h1>치킨!!!</h1>
      <h3>치킨 종류와 상관없이 무조건 만원</h3>
      <div>
        <div className='grid-div'>
          <div>
            <input
             type="radio"
             value={'후라이드치킨'} 
             name='chicken'
             checked={deliveryInfo.chicken === '후라이드치킨'}
             onChange={e => handleDeliveryInfo(e)}
             />
            후라이드치킨
          </div>
          <div>
            <input
             type="radio"
             value={'양념치킨'} 
             name='chicken'
             checked={deliveryInfo.chicken === '양념치킨'}
             onChange={e => handleDeliveryInfo(e)}
             />
            양념치킨
          </div>
          <div>
            <input
             type="radio"
             value={'간장치킨'} 
             name='chicken'
             checked={deliveryInfo.chicken === '간장치킨'}
             onChange={e => handleDeliveryInfo(e)}
             />
            간장치킨
          </div>
          <div>
            <input
             type="radio"
             value={'고추바사삭'} 
             name='chicken'
             checked={deliveryInfo.chicken === '고추바사삭'}
             onChange={e => handleDeliveryInfo(e)}
             />
            고추바사삭
          </div>
          <div>
            <input
             type="radio"
             value={'뿌링클'} 
             name='chicken'
             checked={deliveryInfo.chicken === '뿌링클'}
             onChange={e => handleDeliveryInfo(e)}
             />
            뿌링클
          </div>
          <div>
            <input
             type="radio"
             value={'매운핫치킨'} 
             name='chicken'
             checked={deliveryInfo.chicken === '매운핫치킨'}
             onChange={e => handleDeliveryInfo(e)}
             />
            매운핫치킨
          </div>
        </div>
        <p>마리수</p>
        <input
         type="number" 
         name='cnt'
         value={deliveryInfo.cnt}
         onChange={e => handleDeliveryInfo(e)}
         />
        <p>배달주소</p>
        <select
         value={deliveryInfo.addr}
         name="addr"
         onChange={e => handleDeliveryInfo(e)}
        >
          <option value="">동을 선택하세요.</option>
          <option value="삼산동">삼산동</option>
          <option value="달동">달동</option>
          <option value="신천동">신천동</option>
        </select>
        <p>배달주소 상세</p>
        <input
         type="text"
         value={deliveryInfo.detail} 
         name='detail'
         onChange={e => handleDeliveryInfo(e)}
         />
        <p>요청사항</p>
        <textarea
         rows={3}
         value={deliveryInfo.request}
         name="request"
         onChange={e => handleDeliveryInfo(e)}
        ></textarea>
      </div>
      <div className='btn-div'>
        <button
         type='button'
         onClick={e => regDelivery()} 
        >주문하러 가기</button>
      </div>
    </div>
  )
}

export default FormPractice02