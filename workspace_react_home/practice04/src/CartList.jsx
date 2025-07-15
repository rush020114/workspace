import './CartList.css'

const CartList = () => {
  // 객체를 저장하고 있는 배열 생성
  // 이 객체들이 많아지면 많아질수록 데이터를 넣기가 쉽지 않기 때문에
  // map함수를 이용한다.
  const cartList = [
    {
      category: '상의',
      itemName: '셔츠',
      price: 10000,
      itemCnt: 2
    },
    {
      category: '하의',
      itemName: '청바지',
      price: 15000,
      itemCnt: 1
    },
    {
      category: '신발',
      itemName: '로퍼',
      price: 20000,
      itemCnt: 2
    },
    {
      category: '상의',
      itemName: '맨투맨',
      price: 30000,
      itemCnt: 3
    },
    {
      category: '하의',
      itemName: '슬랙스',
      price: 15000,
      itemCnt: 1
    }
  ]
  return (
    <div className="cartlist_container">
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
        {/* html태그는 중괄호 바깥에 위치해야 한다. */}
        <tbody>
          {
            // cartList의 각 요소에 대한 반복을 하고 그 반복된 요소들을 필요한 데 사용하며 화면에 리턴하게 해줄 map함수
            // e에는 배열 각 요소의 데이터 저장
            // i는 배열의 인덱스
            cartList.map((e, i) => {
              // return 안에는 html코드를 적을 수 있다.
              // map함수는 배열의 길이만큼 반복을 해주기 때문에 현재는 5번 반복한다.
              return (
                <tr key={i}> {/* 똑같은 태그가 반복되면 고유한 key값을 넣어준다. */}
                  <td>{i + 1}</td>
                  <td>{e.category}</td>
                  <td>{e.itemName}</td>
                  <td>{e.price}</td>
                  <td>{e.itemCnt}</td>
                  <td>{e.itemCnt * e.price}</td>
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