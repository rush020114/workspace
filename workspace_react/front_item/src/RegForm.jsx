import axios from 'axios'
import React, { useState } from 'react'
import styles from './RegForm.module.css'

const RegForm = ({nav}) => {

  // 상품 등록 state변수
  const [regForm, setRegForm] = useState({
    itemCategory: ''
    , itemName: ''
    , itemPrice: ''
    , itemStatus: '준비중'
    , itemIntro: ''
  })

  // 데이터베이스에 데이터 저장 시
  // 데이터가 올바른지 검사 -> 유효성 검사(validation 처리)

  // 유효성 검사에 사용할 유효성 변수
  const [isNotValid, setIsNotValid] = useState({
    itemCategory: false
    , itemName: false
    , itemPrice: false
  });

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
    if(checkValid()){
      axios.post('/api/items', regForm)
      .then(res => {})
      .catch(error => console.log(error))
      nav('/')
    }
  }

  // 유효성 검사 함수
  const checkValid = () => {
    // 유효성 검사 결과
    let isValid = true;

    // 유효성 검사
    if(regForm.itemCategory === ''){  
      setIsNotValid({
        ...isNotValid
        , itemCategory: true
      })
      isValid = false;
    }
    
    if(regForm.itemName === ''){  
      setIsNotValid({
        ...isNotValid
        , itemName: true
      })
      isValid = false;
    }
    
    if(regForm.itemPrice === '' || regForm.itemPrice <= 0){  
      setIsNotValid({
        ...isNotValid
        , itemPrice: true
      })
      isValid = false;
    }
    return isValid;
  }

  return (
    <div className={styles.container}>
      <h1 className={styles.reg_title}>상품 등록</h1>
      <div className={styles.reg_content}>
        <div>
          <p>상품 카테고리</p>
          <select
          name='itemCategory'
          value={regForm.itemCategory}
          onChange={e => handleregForm(e)}
          onKeyDown={e => {if(e.key === 'Enter') regFormData()}}
          >
            <option value="">선택</option>
            <option value="상의">상의</option>
            <option value="하의">하의</option>
            <option value="악세사리">악세사리</option>
          </select>
          {
            isNotValid.itemCategory &&
            <p className={styles.not_valid}>상품 카테고리를 선택하세요.</p>
          }
        </div>
        <div>
          <p>상품명</p>
          <input
            type="text" 
            name='itemName'
            value={regForm.itemName}
            onChange={e => handleregForm(e)}
            onKeyDown={e => {if(e.key === 'Enter') regFormData()}}
            />
            {
              isNotValid.itemName && // 단락평가
              <p className={styles.not_valid}>상품명은 필수입력입니다.</p>
            }
        </div>
        <div>
          <p>상품 가격</p>
          <input
            type="text" 
            name='itemPrice'
            value={regForm.itemPrice}
            onChange={e => handleregForm(e)}
            onKeyDown={e => {if(e.key === 'Enter') regFormData()}}
            />
            {
              isNotValid.itemPrice &&
              <p className={styles.not_valid}>상품가격은 필수입력이며, 음수가 들어올 수 없습니다.</p>
            }
        </div>
        <div className={styles.reg_radio}>
          <p>상품 상태</p>
          <div>
            <div>
              <input
                type="radio"
                name='itemStatus' 
                value={'준비중'}
                checked={regForm.itemStatus === '준비중'}
                onChange={e => handleregForm(e)}
                onKeyDown={e => {if(e.key === 'Enter') regFormData()}}
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
                onKeyDown={e => {if(e.key === 'Enter') regFormData()}}
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
                onKeyDown={e => {if(e.key === 'Enter') regFormData()}}
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
            value={regForm.itemIntro}
            onChange={e => handleregForm(e)}
            onKeyDown={e => {if(e.key === 'Enter') regFormData()}}
          ></textarea>
        </div>
      </div>
      <div className={styles.reg_btn}>
        <button
         type='button'
         onClick={e => regFormData()}
        >등록</button>
      </div>
    </div>
  )
}

export default RegForm