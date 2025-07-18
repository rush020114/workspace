import { useEffect, useState } from "react";
import OrderList from "./OrderList";
import OrderDetail from "./OrderDetail";
import axios from "axios";

const OrderInfo = () => {
  const [orderList, setOrderList] = useState([]);
  const [selectedOrder, setSelectedOrder] = useState({});
  const [isShow, setIsShow] = useState(false);

  useEffect(() => {
    axios.get('/api/orders')
    .then((res) => {
      console.log(res.data)
      setOrderList(res.data)
    })
    .catch((error) => console.log(error))
  }, [])

  return(
    <>
      <OrderList orderList={orderList} setSelectedOrder={setSelectedOrder} setIsShow={setIsShow} />
      {
        isShow 
        ?
        <OrderDetail selectedOrder={selectedOrder} />
        :
        null
      }
    </>
  )
}

export default OrderInfo;