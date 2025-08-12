import axios from 'axios'
import React, { useEffect, useState } from 'react'
import styles from './ItemList.module.css'
import dayjs from 'dayjs'

const ItemList = ({nav}) => {

  // 상품 목록 조회 state변수
  const [itemList, setItemList] = useState([])

  console.log(itemList)


  // 상품 목록 조회 axios
  useEffect(() => {
    axios.get('/api/items')
    .then(res => setItemList(res.data))
    .catch(error => console.log(error))
  }, [])

  // 총 상품 가격  
  let sum = 0
  for(const e of itemList){
    sum += e.itemPrice
  }

  return (
    <div className={styles.container}>
      <h1 className={styles.list_title}>상품 목록</h1>      
      <table className={styles.list_table}>
        <colgroup>
          <col width='6%' />
          <col width='13%' />
          <col width='26%' />
          <col width='19%' />
          <col width='11%' />
          <col width='24%' />
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
                  <td>{'￦' + item.itemPrice.toLocaleString()}</td>
                  <td>{item.itemStatus}</td>
                  <td>{dayjs(item.regDate).format('YYYY.MM.DD HH:mm:ss')}</td>
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
        <div>{'￦' + sum.toLocaleString()}</div>
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