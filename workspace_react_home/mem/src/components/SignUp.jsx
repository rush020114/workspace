import React, { useEffect, useState } from 'react'
import styles from './SignUp.module.css'
import Input from '../common/Input'
import Select from '../common/Select'
import Modal from '../common/Modal'
import Button from '../common/Button'
import axios from 'axios'
import { useDaumPostcodePopup } from 'react-daum-postcode'
import { handleSignUpErrorMsg } from '../validate/signUpValidate'

const SignUp = ({isOpenSignUp, onClose}) => {

  // 주소 팝업창 함수
  const open = useDaumPostcodePopup('//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js');

  // 버튼 활성화 state 변수
  const [isDisable, setisDisable] = useState(true);

  // 유효성 검사 문장을 저장할 state 변수
  const [errorMsg, setErrorMsg] = useState({
    memId: ''
    , memPw: ''
    , confirmPw: ''
  })

  // 회원가입 정보 저장 state 변수
  const [signUpData, setSignUpData] = useState({
    memId: ''
    , memPw: ''
    , confirmPw: ''
    , memName: ''
    , memTelArr: ['', '', '']
    , firstIden: ''
    , secondIden: ''
    , memIden: ''
    , memAddr: ''
    , addrDetail: ''
    , memGender: ''
    , firstEmail: ''
    , secondEmail: ''
    , memEmail: ''
  });
  
  // 회원가입 데이터 세팅 함수
  const handleSignUpData = e =>{
    if(e.target.name === 'firstIden' || e.target.name === 'secondIden'){
      setSignUpData({
        ...signUpData
        , [e.target.name]: e.target.value
        , memIden: e.target.name === 'firstIden' 
        ? e.target.value + '-' + signUpData.secondIden
        : signUpData.firstIden + '-' + e.target.value
      });
    }
    else if(e.target.name === 'firstEmail' || e.target.name === 'secondEmail'){
      setSignUpData({
        ...signUpData
        , [e.target.name]: e.target.value
        , memEmail: e.target.name === 'firstEmail'
        ? e.target.value + '@' + signUpData.secondEmail
        : signUpData.firstEmail + '@' + e.target.value
      });
    }
    else{
      setSignUpData({
        ...signUpData
        , [e.target.name]: e.target.value
      });
    };
  };
  
  // 연락처 세팅 함수
  const handleMemTel = (e, index) => {
    signUpData.memTelArr.splice(index, 1, e.target.value);
    setSignUpData({
      ...signUpData
      , memTelArr: signUpData.memTelArr
    });
  };

  // 회원 등록 함수
  const regSignUpData = () => {
    axios.post('/api/members', signUpData)
    .then(res => {
      alert('가입 완료');
      onClose();
      setisDisable(true);
      setErrorMsg({
        memId: ''
        , memPw: ''
        , confirmPw: ''          
      });
      setSignUpData({
        memId: ''
        , memPw: ''
        , confirmPw: ''
        , memName: ''
        , memTelArr: ['', '', '']
        , firstIden: ''
        , secondIden: ''
        , memIden: ''
        , memAddr: ''
        , addrDetail: ''
        , memGender: ''
        , firstEmail: ''
        , secondEmail: ''
        , memEmail: ''
      });
    })
    .catch(e => console.log(e));
  };
  
  // 중복확인
  const isDup = () => {
    axios.get(`/api/members/${signUpData.memId}`)
    .then(res => {
      if(res.data){
        alert('사용 가능');
        setisDisable(false);
      }
      else{
        alert('사용 불가능');
      };
    })
    .catch(e => console.log(e));
  };

  // 주소록 팝업 띄우기 함수
  const handlePost = () => {
    open({onComplete: data => setSignUpData({
      ...signUpData
      , memAddr: data.address
      })
    });
  };

  console.log(errorMsg)
  
  return (
    <Modal
      title='Sign Up'
      isOpen={isOpenSignUp}
      onClose={() => {
        onClose();
        setisDisable(true);
        setErrorMsg({
          memId: ''
          , memPw: ''
          , confirmPw: ''          
        });
        setSignUpData({
          memId: ''
          , memPw: ''
          , confirmPw: ''
          , memName: ''
          , memTelArr: ['', '', '']
          , firstIden: ''
          , secondIden: ''
          , memIden: ''
          , memAddr: ''
          , addrDetail: ''
          , memGender: ''
          , firstEmail: ''
          , secondEmail: ''
          , memEmail: ''
        });
      }}
      size='500px'
      marginTop='30px'
    >
      <div className={styles.container}>
        <div className={styles.content}>
          <div className={styles.id_div}>
            <p>아이디</p>
            <div>
              <Input
                name='memId'
                value={signUpData.memId}
                onChange={e => {
                  handleSignUpData(e);
                  setisDisable(true);
                  setErrorMsg({
                    ...errorMsg
                    , memId: handleSignUpErrorMsg(e)
                  })
                }}
                size='70%'
              />
              <Button 
                size='30%'
                content='중복 확인'
                fontSize=''
                onClick={() => isDup()}
              />
            </div>
            <p className='error'>{errorMsg.memId}</p>
          </div>
          <div>
            <p>비밀번호</p>
            <Input 
              type='password'
              name='memPw'
              value={signUpData.memPw}
              onChange={e => {
                handleSignUpData(e)
                setErrorMsg({
                  ...errorMsg
                  , memPw: handleSignUpErrorMsg(e)
                })
              }}
              size='100%'
            />
            <p className='error'>{errorMsg.memPw}</p>
          </div>
          <div>
            <p>비밀번호 확인</p>
            <Input 
              type='password'
              name='confirmPw'
              value={signUpData.confirmPw}
              onChange={e => {
                handleSignUpData(e)
                setErrorMsg({
                  ...errorMsg
                  , confirmPw: handleSignUpErrorMsg(e, signUpData.memPw)
                })
              }}
              size='100%'
            />
            <p className='error'>{errorMsg.confirmPw}</p>
          </div>
          <div>
            <p>이름</p>
            <Input 
              name='memName'
              value={signUpData.memName}
              onChange={e => handleSignUpData(e)}
              size='100%'
            />
          </div>
          <div className={styles.tel_div}>
            <p>연락처</p>
            <div>
              <Input 
                name='memTelArr'
                value={signUpData.memTelArr[0]}
                onChange={e => handleMemTel(e, 0)}
                size='100%'
                maxLength='3'
              />
              <Input 
                name='memTelArr'
                value={signUpData.memTelArr[1]}
                onChange={e => handleMemTel(e, 1)}
                size='100%'
                maxLength='4'
              />
              <Input 
                name='memTelArr'
                value={signUpData.memTelArr[2]}
                onChange={e => handleMemTel(e, 2)}
                size='100%'
                maxLength='4'
              />
            </div>
          </div>
          <div className={styles.iden_div}>
            <p>주민등록번호</p>
            <div>
              <Input 
                name='firstIden'
                value={signUpData.firstIden}
                onChange={e => handleSignUpData(e)}
                size='100%'
                maxLength='6'
              />
              <Input 
                type='password'
                name='secondIden'
                value={signUpData.secondIden}
                onChange={e => handleSignUpData(e)}
                size='100%'
                maxLength='7'
              />
            </div>
          </div>
          <div className={styles.addr_div}>
            <p>주소</p>
            <div>
              <div>
                <Input 
                  name='memAddr'
                  value={signUpData.memAddr}
                  onChange={e => handleSignUpData(e)}
                  readOnly={true}
                  onClick={() => handlePost()}
                  size='70%'
                />
                <Button 
                  onClick={() => handlePost()}
                  size='30%'
                  fontSize=''
                  content='검 색'
                />
              </div>
              <Input 
                name='addrDetail'
                value={signUpData.addrDetail}
                onChange={e => handleSignUpData(e)}
                size='100%'
              />
            </div>
          </div>
          <div className={styles.gender_div}>
            <p>성별</p>
            <div>
              <div>
                <input type="radio" 
                  name='memGender'
                  value={'남'}
                  checked={signUpData.memGender === '남'}
                  onChange={e => handleSignUpData(e)}
                />
                남
              </div>
              <div>
                <input type="radio" 
                  name='memGender'
                  value={'여'}
                  checked={signUpData.memGender === '여'}
                  onChange={e => handleSignUpData(e)}
                />
                여
              </div>
            </div>
          </div>
          <div className={styles.email_div}>
            <p>이메일</p>
            <div>
              <Input
                name='firstEmail'
                value={signUpData.firstEmail}
                onChange={e => handleSignUpData(e)}
                size='100%'
              />
              <Select
                name='secondEmail'
                value={signUpData.secondEmail}
                onChange={e => handleSignUpData(e)}
                size='100%'
              >
                <option value="">선택</option>
                <option value="gmail.com">gmail.com</option>
                <option value="naver.com">naver.com</option>
              </Select>
            </div>
          </div>
        </div>
        <div className={styles.btn_div}>
          <Button
            content='회원 가입'
            size='100%'
            fontSize=''
            onClick={() => regSignUpData()}
            disabled={isDisable}
          />
        </div>
      </div>
    </Modal>
  )
}

export default SignUp