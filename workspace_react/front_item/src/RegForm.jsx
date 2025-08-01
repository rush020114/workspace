import axios from 'axios'
import React, { useState } from 'react'

const RegForm = ({nav}) => {

  // 상품 등록 state변수
  const [regForm, setRegForm] = useState({
    itemCategory: ''
    , itemName: ''
    , itemPrice: ''
    , itemStatus: '준비중'
    , itemIntro: ''
  })

  console.log(regForm)

  // 상품 등록 이벤트 함수
  const handleregForm = e => {
    setRegForm({
      ...regForm
      , [e.target.name]: e.target.value
    })
  }

  // 상품 등록 axios
  const regFormData = () => {
    if(regForm.itemCategory === '' 
    || 
    regForm.itemName === '' 
    || 
    regForm.itemPrice === ''){
      alert('필수입력사항(카테고리, 상품명, 가격)')
      return
    }
    axios.post('/api/items', regForm)
    .then(res => {})
    .catch(error => console.log(error))
    nav('/')
  }

  return (
    <div>
      <div>
        <p>상품 카테고리</p>
        <select
         name='itemCategory'
         value={regForm.itemCategory}
         onChange={e => handleregForm(e)}
         >
          <option value="">선택</option>
          <option value="상의">상의</option>
          <option value="하의">하의</option>
          <option value="악세사리">악세사리</option>
        </select>
      </div>
      <div>
        <div>
          <p>상품명</p>
          <input
           type="text" 
           name='itemName'
           value={regForm.itemName}
           onChange={e => handleregForm(e)}
           />
        </div>
        <div>
          <p>상품 가격</p>
          <input
           type="text" 
           name='itemPrice'
           value={regForm.itemPrice}
           onChange={e => handleregForm(e)}
           />
        </div>
        <div>
          <p>상품 상태</p>
          <div>
            <div>
              <input
               type="radio"
               name='itemStatus' 
               value={'준비중'}
               checked={regForm.itemStatus === '준비중'}
               onChange={e => handleregForm(e)}
              />
              <p>준비중</p>
            </div>
            <div>
              <input
               type="radio"
               name='itemStatus' 
               value={'판매중'}
               checked={regForm.itemStatus === '판매중'}
               onChange={e => handleregForm(e)}
              />
              <p>판매중</p>
            </div>
            <div>
              <input
               type="radio"
               name='itemStatus' 
               value={'매진'}
               checked={regForm.itemStatus === '매진'}
               onChange={e => handleregForm(e)}
              />
              <p>매진</p>
            </div>
          </div>
        </div>
        <div>
          <p>상품 소개</p>
          <textarea 
           name="itemIntro"
           value={regForm.itemIntro}
           onChange={e => handleregForm(e)}
          ></textarea>
        </div>
      </div>
      <div>
        <button
         type='button'
         onClick={e => regFormData()}
        >등록</button>
      </div>
    </div>
  )
}

export default RegForm