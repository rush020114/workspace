import axios from 'axios'
import React, { useEffect, useState } from 'react'
import styles from './ItemList.module.css'

const ItemList = ({nav}) => {

  // 조회된 상품 목록을 담을 state변수
  const [itemList, setItemList] = useState([])

  // 상품 목록 조회 useEffect
  useEffect(() => {
    axios.get('/api/items')
    .then(res => setItemList(res.data))
    .catch(e => console.log(e))
  }, [])

  // 총상품 가격
  let sum = 0

  // 총상품 가격 구하는 함수
  itemList.forEach(e => sum += e.itemPrice)

  return (
    <div className={styles.container}>
      <h1 className={styles.list_title}>상품 목록</h1>
      <table className={styles.list_table}>
        <colgroup>
          <col width='7%' />
          <col width='17%' />
          <col width='17%' />
          <col width='17%' />
          <col width='17%' />
          <col width='25%' />
        </colgroup>
        <thead>
          <tr>
            <td>No</td>
            <td>카테고리</td>
            <td>상품명</td>
            <td>가격</td>
            <td>상태</td>
            <td>등록일</td>
          </tr>
        </thead>
        <tbody>
          {
            itemList.length !== 0
            ?
            itemList.map((item, i) => {
              return(
                <tr
                 key={i}
                 onClick={e => nav(`/detail/${item.itemNum}`)}
                >
                  <td>{itemList.length - i}</td>
                  <td>{item.itemCategory}</td>
                  <td>{item.itemName}</td>
                  <td>{item.itemPrice}</td>
                  <td>{item.itemStatus}</td>
                  <td>{item.regDate}</td>
                </tr>
              )
            })
            :
            <tr>
              <td colSpan={6}>조회된 데이터가 없습니다.</td>
            </tr>
          }
        </tbody>
      </table>
      <div className={styles.list_sum}>
        <div>총 등록 가격</div>
        <div>{sum}원</div>
      </div>
      <div className={styles.list_btn}>
        <button
         type='button'
         onClick={e => nav('/reg')}
        >상품 등록</button>
      </div>
    </div>
  )
}

export default ItemList