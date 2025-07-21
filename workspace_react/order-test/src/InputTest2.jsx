import axios from 'axios'
import React, { useState } from 'react'

const InputTest2 = () => {

  const [itemInfo, setItemInfo] = useState({itemName: '', itemPrice: 0, itemCnt: 1})

  const regOrder = () => {
    axios.post('/api/orders', itemInfo)
    .then(res => {
      console.log(res.data)
    })
    .catch(error => console.log(error))
  }

  return (
    <div>
      <input value={itemInfo.itemName} type="text" onChange={e => {
          setItemInfo({
            ...itemInfo,
            'itemName' : e.target.value
          })
        }} /> <br />
      <input value={itemInfo.itemPrice} type="text" onChange={e => {
          setItemInfo({
            ...itemInfo,
            'itemPrice' : e.target.value
          })
        }} /> <br />
      <input value={itemInfo.itemCnt} type="text" onChange={e => {
         setItemInfo({
            ...itemInfo,
            'itemCnt' : e.target.value
          })
        }} /> <br />
      <button type='button' onClick={e => regOrder()}>상품등록</button>
    </div>
  )
}

export default InputTest2