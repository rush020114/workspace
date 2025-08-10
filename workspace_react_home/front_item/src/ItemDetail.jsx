import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import styles from './ItemDetail.module.css'

const ItemDetail = ({nav}) => {

  // 상품번호를 받아오기 위한 파라미터 변수
  const {itemNum} = useParams()

  // 조회한 하나의 상품을 담을 state변수
  const [itemDetail, setItemDetail] = useState({})

  // 상품 상세 조회 useEffect
  useEffect(() => {
    axios.get(`/api/items/${itemNum}`)
    .then(res => setItemDetail(res.data))
    .catch(e => console.log(e))
  }, [])

  // 상품 삭제 함수
  const deleteItem = () => {
    confirm('삭제하시겠습니까?')
    &&
    axios.delete(`/api/items/${itemNum}`)
    .then(res => {
      alert('삭제 성공')
      nav('/')
    })
    .catch(e => console.log(e))
  }

  return (
    <div className={styles.container}>
      <h1 className={styles.detail_title}>상품 상세 조회</h1>
      <table className={styles.detail_table}>
        <colgroup>
          <col width='20%' />
          <col width='30%' />
          <col width='20%' />
          <col width='30%' />
        </colgroup>
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
      <div className={styles.detail_btn}>
        <button
         type='button'
         onClick={e => nav('/')}
        >목록</button>
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