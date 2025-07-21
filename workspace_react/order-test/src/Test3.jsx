import axios from "axios"

const Test3 = () => {

  axios.post('/api/orders', {itemNum: '1', itemName: '상품1', itemPrice: 5000, itemCnt: 3, buyerId: 'abc', totalPrice: 15000})
  .then(res => console.log(res.data))
  .catch(error => console.log(error))

  return(
    <div>test3</div>
  )
}

export default Test3