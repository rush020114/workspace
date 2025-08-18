import React, { useState } from 'react'
import Modal from '../common/Modal'
import Input from '../common/Input'
import Button from '../common/Button'
import styles from './Join.module.css'
import Select from '../common/Select'
import axios from 'axios'

const Join = ({isOpenJoin, onClose}) => {
  // 아이디 유효성 검사 결과를 저장할 state 변수
  const[errorMsg, setErrorMsg] = useState('');

  // 회원가입 버튼 사용 가능 여부를 저장하는 state 변수
  const [isDisable, setIsDisable] = useState(true)

  // 회원가입 시 입력한 내용을 저장할 state 변수
  const [joinData, setJoinData] = useState({
    memId: ''
    , memPw: ''
    , confirmPw: ''
    , memName: ''
    , memTelArr: ['', '', '']
    , firstEmail: ''
    , secondEmail: ''
    , memEmail: ''
    , memAddr: ''
    , addrDetail: ''
  });

  // 값 입력 시 실행할 함수
  const handleJoinData = e => {
    // 이메일을 변경했으면
    if(e.target.name === 'firstEmail' || e.target.name === 'secondEmail'){
      setJoinData({
        ...joinData
        , [e.target.name]: e.target.value 
        , memEmail: e.target.name === 'firstEmail'
                    ?
                    e.target.value + joinData.secondEmail
                    :
                    joinData.firstEmail + e.target.value
      });
    }
    // 이메일이 제외한 다른 데이터를 변경했으면
    else{
      setJoinData({
      ...joinData
      , [e.target.name]: e.target.value
      });
    };
  };

  // 연락처 변경 시 실행 함수
  const handleMemTel = (index, e) => {
    joinData.memTelArr.splice(index, 1, e.target.value);
    setJoinData({
      ...joinData
      , memTelArr: joinData.memTelArr
    });
  };

  // 회원가입 버튼 클릭 시 실행 함수
  const join = () => {

    axios.post('/api/members', joinData)
    .then(res => {
      alert('회원가입 성공');
      // 모달 창을 닫고 입력한 값 초기화
      onClose();
      setJoinData({
        memId: ''
        , memPw: ''
        , confirmPw: ''
        , memName: ''
        , memTelArr: ['', '', '']
        , firstEmail: ''
        , secondEmail: ''
        , memEmail: ''
        , memAddr: ''
        , addrDetail: ''
      });
    })
    .catch(e => console.log(e))
  };

  // 아이디 사용 가능 여부 확인 함수
  const checkId = () => {
    axios.get(`/api/members/check-id/${joinData.memId}`)
    .then(res => {
      if(res.data){
        alert('사용가능')
        setIsDisable(false);
      }
      else{
        alert('사용불가능')
      }
    })
    .catch(e => console.log(e))

  }

  console.log(joinData)

  return (
    <Modal
     size='400px'
     title='join'
     isOpen={isOpenJoin}
     onClose={() => {
      // x 버튼 클릭 시 회원가입 버튼을 비활성화
      setIsDisable(true);
      
      // x 버튼 클릭 시 모달을 닫히게 하는 함수
      onClose();
      
      // 입력한 값 초기화
      setJoinData({
        memId: ''
        , memPw: ''
        , confirmPw: ''
        , memName: ''
        , memTelArr: ['', '', '']
        , firstEmail: ''
        , secondEmail: ''
        , memEmail: ''
        , memAddr: ''
        , addrDetail: ''
      });
     }}
    >
      <div className={styles.container}>
        <div className={styles.id_div}>
          <p>아이디</p>
          <div>
            <Input
             size='75%' 
             name='memId'
             value={joinData.memId}
             onChange={e => {
              handleJoinData(e);
              setIsDisable(true);

              // 아이디 유효성 검사(정규식 사용)
              // 4~8글자, 영문과 숫자만 가능
              const memIdRegex = /^[a-zA-Z0-9]{4,8}$/;
              
              // 유효성 검사
              if(!e.target.value){ // 빈문자열이면
                setErrorMsg('아이디는 필수입력입니다.')
              }
              else if(e.target.value.length < 4 || e.target.value.length > 8){
                setErrorMsg('아이디는 4~8글자입니다.')
              }
              else if(!memIdRegex.test(e.target.value)){
                setErrorMsg('아이디는 영문, 숫자만 가능합니다.')
              }
              else{
                setErrorMsg('')
              }
             }}
            />
            <Button
             size='25%' 
             title='중복 확인'
             color='green'
             onClick={e => checkId()}
            />
          </div>
          <p className={styles.error}>{errorMsg}</p>
        </div>
        <div>
          <p>비밀번호</p>
          <Input 
           size='100%'
           type='password'
           name='memPw'
           value={joinData.memPw}
           onChange={e => {
            handleJoinData(e)

            const memPwRegex = /^(?=.*[A-Za-z])(?=.*\d)[A-Za-z\d]{6,12}$/;
            if(!e.target.value){

            }
            // 비밀번호
            // 1. 필수입력
            // 2. 6~12글자
            // 3. 영문 + 숫자 조합만 가능(정규식)
          }}
          />
          <p className={styles.error}>{errorMsg}</p>
        </div>
        <div>
          <p>비밀번호 확인</p>
          <Input 
           size='100%'
           type='password'
           name='confirmPw'
           value={joinData.confirmPw}
           onChange={e => handleJoinData(e)}
          />
        </div>
        <div>
          <p>회원명</p>
          <Input 
           size='100%'
           name='memName'
           value={joinData.memName}
           onChange={e => handleJoinData(e)}
          />
        </div>
        <div className={styles.tel_div}>
          <p>연락처</p>
          <div>
            <Input size='100%' 
             maxLength='3'
             name='memTelArr'
             value={joinData.memTelArr[0]}
             onChange={e => {
              handleMemTel(0, e)
             }}
            />
            <Input size='100%' 
             maxLength='4'
             name='memTelArr'
             value={joinData.memTelArr[1]}
             onChange={e => {
              handleMemTel(1, e)
             }}
            />
            <Input size='100%' 
             maxLength='4'
             name='memTelArr'
             value={joinData.memTelArr[2]}
             onChange={e => {
              handleMemTel(2, e)
             }}
            />
          </div>
        </div>
        <div className={styles.email_div}>
          <p>이메일</p>
          <div>
            <Input
             size='100%' 
             name='firstEmail'
             value={joinData.firstEmail}
             onChange={e => handleJoinData(e)}
            />
            <Select
             size='100%'
             name='secondEmail'
             value={joinData.secondEmail}
             onChange={e => handleJoinData(e)}
            >
              <option value=''>전체</option>
              <option value='@gmail.com'>@gmail.com</option>
              <option value='@naver.com'>@naver.com</option>
            </Select>
          </div>
        </div>
        <div className={styles.addr_div}>
          <p>주소</p>
          <div>
            <div>
              <Input
               size='80%' 
               name='memAddr'
               value={joinData.memAddr}
               onChange={e => handleJoinData(e)}
              />
              <Button
               size='20%' 
               title='검 색'
               color='green'
              />
            </div>
            <Input size='100%' 
             name='addrDetail'
             value={joinData.addrDetail}
             onChange={e => handleJoinData(e)}
            />
          </div>
        </div>
        <div>
          <Button 
           size='100%' 
           title='회 원 가 입'
           color='green'
           onClick={() => join()}
           disabled={isDisable} // 처음엔 사용불가
          />
        </div>
      </div>
    </Modal>
  )
}

export default Join