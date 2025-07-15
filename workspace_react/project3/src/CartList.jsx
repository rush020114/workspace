import './CartList.css'

// 장바구니 목록
const CartList = () => {
  const cartList = [
     {
      category : '상의',
      itemName : '셔츠',
      itemPrice : 10000,
      cartCnt : 2,
    }, 
    {
      category : '하의',
      itemName : '청바지',
      itemPrice : 15000,
      cartCnt : 1,
    }, 
    {
       category : '신발',
       itemName : '로퍼',
       itemPrice : 20000,
       cartCnt : 2,
    }, 
    {
       category : '상의',
       itemName : '맨투맨',
       itemPrice : 30000,
       cartCnt : 3,
    }, 
    {
       category : '하의',
       itemName : '슬랙스',
       itemPrice : 15000,
       cartCnt : 1,
    }
  ]

  return(
    <div className="cartList_container">
      <table>
        <thead>
          <tr>
            <td>NO</td>
            <td>카테고리</td>
            <td>상품명</td>
            <td>가격</td>
            <td>수량</td>
            <td>총가격</td>
          </tr>
        </thead>
        <tbody>
          {
            cartList.map((e, i) => {
              return(
              // 리액트에는 반복될 때 고유한 무언가를 key로 주어야 하는 약속을 했다.
              <tr key={i}> 
                <td>{i + 1}</td>
                <td>{e.category}</td>
                <td>{e.itemName}</td>
                <td>{e.itemPrice}</td>
                <td>{e.cartCnt}</td>
                <td>{e.itemPrice * e.cartCnt}</td>
              </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default CartList