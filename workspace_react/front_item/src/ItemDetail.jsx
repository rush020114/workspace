import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

const ItemDetail = ({nav}) => {

  // 기본페이지에서 이어져 받는 상품번호
  const {itemNum} = useParams()

  // 상품 조회 useState
  const [itemDetail, setItemDetail] = useState({})

  // 상품 조회 axios
  useEffect(() => {
    axios.get(`/api/items/${itemNum}`)
    .then(res => setItemDetail(res.data))
    .catch(error => console.log(error))
  }, [])

  // 상품 삭제 axios
  const deleteItem = () => {
    confirm('정말로 삭제하시겠습니까?')
    &&
    axios.delete(`/api/items/${itemNum}`)
    .then(res => alert('삭제되었습니다.'))
    .catch(error => console.log(error))
    nav('/')
  }

  return (
    <div>
      <table>
        <tbody>
          <tr>
            <td>상품번호</td>
            <td>{itemDetail.itemNum}</td>
            <td>카테고리</td>
            <td>{itemDetail.itemCategory}</td>
          </tr>
          <tr>
            <td>상품명</td>
            <td>{itemDetail.itemName}</td>
            <td>가격</td>
            <td>{itemDetail.itemPrice}</td>
          </tr>
          <tr>
            <td>상태</td>
            <td>{itemDetail.itemStatus}</td>
            <td>등록일</td>
            <td>{itemDetail.regDate}</td>
          </tr>
          <tr>
            <td>상품 소개</td>
            <td colSpan={3}>{itemDetail.itemIntro}</td>
          </tr>
        </tbody>
      </table>
      <div>
        <button
         type='button'
         onClick={e => nav('/')}
        >목록가기</button>
        <button
         type='button'
         onClick={e => nav(`/update/${itemNum}`)}
        >수정</button>
        <button
         type='button'
         onClick={e => deleteItem()}
        >삭제</button>
      </div>
    </div>
  )
}

export default ItemDetail