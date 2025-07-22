
// 구매정보 데이터를 입력받는 input 태그를 만들고 해당 인풋태그에 입력한 정보를 
// buyInfo 변수에 저장시켜보세요.
// 입력 받는 구매정보로는 상품명, 수량, 가격, 구매자명이 있다.

import { useState } from "react"

const InputTest5 = () => {

  const [buyInfo, setBuyInfo] = useState({
    name: '',
    cnt: 1,
    price: 0,
    buyer: ''
  }) 

  const handleInputData = e => {
    setBuyInfo({
      ...buyInfo,
      [e.target.name]: e.target.value
    })
  }

  console.log(buyInfo)

  return(
    <div>
      <p>상품명</p>
      <input
       type="text" 
       name="name" 
       value={buyInfo.name}
       onChange={e => handleInputData(e)} 
      />
      <p>수량</p>
      <input 
       type="number" 
       name="cnt" 
       value={buyInfo.cnt} 
       onChange={e => handleInputData(e)} 
      />
      <p>가격</p>
      <input
       type="text" 
       name="price" 
       value={buyInfo.price}
       onChange={e => handleInputData(e)} 
      />
      <p>구매자명</p>
      <input
       type="text" 
       name="buyer" 
       value={buyInfo.buyer}
       onChange={e => handleInputData(e)} 
      />
    </div>
  )
}

export default InputTest5