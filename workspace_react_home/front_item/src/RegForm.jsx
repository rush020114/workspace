import React, { useState } from 'react'
import ItemList from './ItemList'
import axios from 'axios'
import styles from './RegFrom.module.css'

const RegForm = ({nav}) => {

  // 등록할 상품 state변수
  const [regItem, setRegItem] = useState({
    itemCategory: ''
    , itemName: ''
    , itemPrice: ''
    , itemStatus: '준비중'
    , itemIntro: ''
  })

  // 등록 상품 입력값 저장 함수
  const handleRegItem = e => {
    setRegItem({
      ...regItem
      , [e.target.name]: e.target.value
    })
  }

  // 상품 등록 함수
  const regItemData = () => {
    if(regItem.itemCategory === ''
    || regItem.itemName === ''
    || regItem.itemPrice === ''){
      alert('카테고리, 상품명 또는 가격을 입력해주세요.')
      return
    }
    confirm('등록하시겠습니까?')
    &&
    axios.post('/api/items', regItem)
    .then(res => {
      alert('등록성공')
      nav('/')
    })
    .catch(e => console.log(e))
  }

  console.log(regItem)

  return (
    <div className={styles.container}>
      <h1 className={styles.reg_title}>상품 등록</h1>
      <div className={styles.reg_content}>
        <div>
          <p>상품 카테고리</p>
          <select
           name="itemCategory"
           value={regItem.itemCategory}
           onChange={e => handleRegItem(e)}
           onKeyDown={e => {if(e.key === 'Enter') regItemData()}}
          >
            <option value="">선택</option>
            <option value="상의">상의</option>
            <option value="하의">하의</option>
            <option value="악세사리">악세사리</option>
          </select>
        </div>
        <div>
          <p>상품명</p>
          <input
           type="text"
           name='itemName' 
           value={regItem.itemName}
           onChange={e => handleRegItem(e)}
           onKeyDown={e => {if(e.key === 'Enter') regItemData()}}
          />
        </div>
        <div>
          <p>상품 가격</p>
          <input
           type="text" 
           name='itemPrice'
           value={regItem.itemPrice}
           onChange={e => handleRegItem(e)}
           onKeyDown={e => {if(e.key === 'Enter') regItemData()}}
          />
        </div>
        <div className={styles.reg_radio}>
          <p>상품 상태</p>
          <div>
            <div>
              <input
               type="radio" 
               name='itemStatus'
               value={'준비중'}
               checked={regItem.itemStatus === '준비중'}
               onChange={e => handleRegItem(e)}
               onKeyDown={e => {if(e.key === 'Enter') regItemData()}}
              />
              <p>준비중</p>
            </div>
            <div>
              <input
               type="radio" 
               name='itemStatus'
               value={'판매중'}
               checked={regItem.itemStatus === '판매중'}
               onChange={e => handleRegItem(e)}
               onKeyDown={e => {if(e.key === 'Enter') regItemData()}}
              />
              <p>판매중</p>
            </div>
            <div>
              <input
               type="radio"
               name='itemStatus'
               value={'매진'}
               checked={regItem.itemStatus === '매진'}
               onChange={e => handleRegItem(e)}
               onKeyDown={e => {if(e.key === 'Enter') regItemData()}}
              />
              <p>매진</p>
            </div>
          </div>
        </div>
        <div>
          <p>상품 소개</p>
          <textarea
           rows={5}
           name="itemIntro"
           value={regItem.itemIntro}
           onChange={e => handleRegItem(e)}
           onKeyDown={e => {if(e.key === 'Enter') regItemData()}}
          ></textarea>
        </div>
      </div>
      <div className={styles.reg_btn}>
        <button
         type='button'
         onClick={e => regItemData()}
        >등록</button>
      </div>
    </div>
  )
}

export default RegForm