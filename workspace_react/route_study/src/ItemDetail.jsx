import React from 'react'
import { useParams } from 'react-router-dom'

const ItemDetail = () => {
  // url에서 넘어오는 데이터를 받기 위해 useParams() 훅을 사용
  const {itemNum, title} = useParams()

  console.log(title)
  console.log(itemNum)

  return (
    <div>
      <div>상품 상세 정보 페이지</div>
    </div>
  )
}

export default ItemDetail