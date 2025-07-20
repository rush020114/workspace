import { useEffect, useState } from 'react'
import OrderDetail from './OrderDetail'
import OrderList from './OrderList'
import axios from 'axios';

const OrderInfo = () => {

  const [orderList, setOrderList] = useState([]);
  const [selectedOrder, setSelectedOrder] = useState({});
  const [isShow, setIsShow] = useState(false);

  console.log(selectedOrder)

  useEffect(() => {
    axios.get('/api/orders')
    .then((res) =>{
      console.log(res.data);
      setOrderList(res.data);
    })
    .catch((error) => console.log(error))
  }, [])

  return (
    <>
      <OrderList orderList={orderList} setSelectedOrder={setSelectedOrder} setIsShow={setIsShow}/>
      {isShow ? <OrderDetail selectedOrder={selectedOrder} /> : null}
    </>
  )
}

export default OrderInfo