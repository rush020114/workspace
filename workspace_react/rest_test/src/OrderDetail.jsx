import './OrderDetail.css'
const OrderDetail = ({selectedOrder}) => {
  console.log(selectedOrder)
  
  return(
    <div className="detail_container">
      <h1 className='detail-h1'>주문 상세 정보</h1>
      <table className="detail-table">
        <colgroup>
          <col width='25%' />
          <col width='25%' />
          <col width='25%' />
          <col width='25%' />
        </colgroup>
        <tbody>
          <tr>
            <td>상품번호</td>
            <td>{selectedOrder.itemNum}</td>
            <td>상품명</td>
            <td>{selectedOrder.itemName}</td>
          </tr>
          <tr>
            <td>가격</td>
            <td>{selectedOrder.itemPrice}원</td>
            <td>수량</td>
            <td>{selectedOrder.itemCnt}</td>
          </tr>
          <tr>
            <td>주문자ID</td>
            <td>{selectedOrder.buyerId}</td>
            <td>구매금액</td>
            <td>{selectedOrder.itemPrice * selectedOrder.itemCnt}원</td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default OrderDetail