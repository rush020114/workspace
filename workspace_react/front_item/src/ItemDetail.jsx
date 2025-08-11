import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import styles from './ItemDetail.module.css'
import dayjs from 'dayjs'

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
    .then(res => {
      alert('삭제되었습니다.')
      nav('/')
    })
    .catch(error => console.log(error))
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
            <td>
              {
                // truthy, falsy를 이용한 문법
                // falsy는 빈문자열, 0, null, undefined이고 truthy는 이를 제외한 값이다.
                // const a = 0 && 10 <- 0저장
                // const a = 3 && 10 <- 10저장
                itemDetail.itemPrice &&
                '￦' + itemDetail.itemPrice.toLocaleString()
              }
            </td>
          </tr>
          <tr>
            <td>상태</td>
            <td>{itemDetail.itemStatus}</td>
            <td>등록일</td>
            <td>{dayjs(itemDetail.regDate).format('YYYY.MM.DD HH:mm:ss')}</td>
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