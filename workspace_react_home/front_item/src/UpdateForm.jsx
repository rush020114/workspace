import axios from 'axios'
import React, { use, useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import styles from './UpdateForm.module.css'

const UpdateForm = ({nav}) => {

  // 상품 번호를 받아오기 위한 파라미터 변수
  const {itemNum} = useParams()

  // 수정할 상품 기본데이터를 담기 위한 state변수
  const [item, setItem] = useState({})

  // 수정할 상품 state변수
  const [updateForm, setUpdateForm] = useState({
    itemCategory: ''
    , itemName: ''
    , itemPrice: ''
    , itemStatus: ''
    , itemIntro: ''
  })

  // 기본 데이터를 조회하기 위한 useEffect
  useEffect(() => {
    axios.get(`/api/items/${itemNum}`)
    .then(res => setItem(res.data))
    .catch(e => console.log(e))
  }, [])

  // 수정할 상품에 조회한 기본값을 저장해줄 useEffect
  useEffect(() => {
    item.itemCategory !== undefined
    &&
    setUpdateForm({
      itemCategory: item.itemCategory
      , itemName: item.itemName
      , itemPrice: item.itemPrice
      , itemStatus: item.itemStatus
      , itemIntro: item.itemIntro
    })
  }, [item])

  // 수정 상품 입력값 저장 함수
  const handleUpdateForm = (e) => {
    setUpdateForm({
      ...updateForm
      , [e.target.name]: e.target.value
    })
  }

  // 하나의 상품 수정 함수
  const updateItemData = () => {
    confirm('수정하시겠습니까?')
    &&
    axios.put(`/api/items/${itemNum}`, updateForm)
    .then(res => {
      alert('수정성공')
      nav(`/detail/${itemNum}`)
    })
    .catch(e => console.log(e))
  }

  console.log(updateForm)

  return (
    <div className={styles.container}>
      <h1 className={styles.update_title}>상품 수정</h1>
      <div className={styles.update_content}>
        <div>
          <p>상품 카테고리</p>
          <select
           name="itemCategory"
           value={updateForm.itemCategory}
           onChange={e => handleUpdateForm(e)}
           onKeyDown={e => {if(e.key === 'Enter') updateItemData()}}
          >
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
           value={updateForm.itemName}
           onChange={e => handleUpdateForm(e)}
           onKeyDown={e => {if(e.key === 'Enter') updateItemData()}}
          />
        </div>
        <div>
          <p>상품 가격</p>
          <input
           type="text" 
           name='itemPrice'
           value={updateForm.itemPrice}
           onChange={e => handleUpdateForm(e)}
           onKeyDown={e => {if(e.key === 'Enter') updateItemData()}}
          />
        </div>
        <div className={styles.update_radio}>
          <p>상품 상태</p>
          <div>
            <div>
              <input
               type="radio"
               name='itemStatus'
               value={'준비중'} 
               checked={updateForm.itemStatus === '준비중'}
               onChange={e => handleUpdateForm(e)}
               onKeyDown={e => {if(e.key === 'Enter') updateItemData()}}
              />
              <p>준비중</p>
            </div>
            <div>
              <input
               type="radio" 
               name='itemStatus'
               value={'판매중'} 
               checked={updateForm.itemStatus === '판매중'}
               onChange={e => handleUpdateForm(e)}
               onKeyDown={e => {if(e.key === 'Enter') updateItemData()}}
              />
              <p>판매중</p>
            </div>
            <div>
              <input
               type="radio" 
               name='itemStatus'
               value={'매진'} 
               checked={updateForm.itemStatus === '매진'}
               onChange={e => handleUpdateForm(e)}
               onKeyDown={e => {if(e.key === 'Enter') updateItemData()}}
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
           value={updateForm.itemIntro}
           onChange={e => handleUpdateForm(e)}
           onKeyDown={e => {if(e.key === 'Enter') updateItemData()}}
          ></textarea>
        </div>
      </div>
      <div className={styles.update_btn}>
        <button
         type='button'
         onClick={e => nav(`detail/${itemNum}`)}
        >취소</button>
        <button
         type='button'
         onClick={e => updateItemData()}
        >수정</button>
      </div>
    </div>
  )
}

export default UpdateForm