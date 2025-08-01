import axios from 'axios'
import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'

const UpdateForm = ({nav}) => {

  // detail에서 이어지는 상품 번호
  const {itemNum} = useParams()

  // 수정하기 전의 기본값을 받아오기 위한 state변수
  const [item, setItem] = useState({})

  // 수정하는 값을 받을 state 변수
  const [updateItem, setUpdateItem] = useState({
    itemCategory: ''
    , itemName: ''
    , itemPrice: ''
    , itemStatus: ''
    , itemIntro: ''
  })

  // 수정을 위해 detail에서의 기본값을 조회하기 위한 useEffect
  useEffect(() => {
    axios.get(`/api/items/${itemNum}`)
    .then(res => setItem(res.data))
    .catch(error => console.log(error))
  }, [])
  
  // 이벤트를 적용할 변수를 세팅해주는 useEffect
  useEffect(() => {
    item.itemCategory !== undefined
    &&
    setUpdateItem(item)
  }, [item])

  // 입력된 값을 저장할 함수
  const handleUpdateData = e => {
    setUpdateItem({
      ...updateItem
      , [e.target.name]: e.target.value
    })
  }

  // 수정된 글 등록
  const updateFormData = () => {
    axios.put(`/api/items/${itemNum}`, updateItem)
    .then(res => alert('수정 성공'))
    .catch(error => console.log(error))
    nav(`/detail/${itemNum}`)
  }
  
  console.log(updateItem)
  return (
    <div>
      <div>
        <p>상품 카테고리</p>
        <select
         name="itemCategory"
         value={updateItem.itemCategory}
         onChange={e => handleUpdateData(e)}
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
         name="itemName"
         value={updateItem.itemName}
         onChange={e => handleUpdateData(e)}
         />
      </div>
      <div>
        <p>상품 가격</p>
        <input
         type="text" 
         name='itemPrice'
         value={updateItem.itemPrice}
         onChange={e => handleUpdateData(e)}
         />
      </div>
      <div>
        <p>상품 상태</p>
        <div>
          <input
           type="radio"
           name='itemStatus'
           value={'준비중'}
           checked={updateItem.itemStatus === '준비중'}
           onChange={e => handleUpdateData(e)}
           />
           <p>준비중</p>
        </div>
        <div>
          <input
           type="radio"
           name='itemStatus'
           value={'판매중'}
           checked={updateItem.itemStatus === '판매중'}
           onChange={e => handleUpdateData(e)}
           />
           <p>판매중</p>
        </div>
        <div>
          <input
           type="radio"
           name='itemStatus'
           value={'매진'}
           checked={updateItem.itemStatus === '매진'}
           onChange={e => handleUpdateData(e)}
           />
           <p>매진</p>
        </div>
      </div>
      <div>
        <p>상품 소개</p>
        <textarea 
         name="itemIntro"
         value={updateItem.itemIntro}
         onChange={e => handleUpdateData(e)}
        ></textarea>
      </div>
      <div>
        <button
         type='button'
         onClick={e => updateFormData()}
        >수정</button>
      </div>
    </div>
  )
}

export default UpdateForm