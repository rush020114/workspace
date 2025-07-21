import axios from 'axios'
import React from 'react'

const Test5 = () => {

  axios.put('/api/orders/5', {itemName: '상품3', itemPrice: 3000, itemCnt: 2})
  .then(res => console.log(res.data))
  .catch(error => console.log(error))

  return (
    <div>Test5</div>
  )
}

export default Test5