import React, { useState } from 'react'
import styles from './Join.module.css'
import Modal from '../common/Modal'
import Input from '../common/Input'
import Button from '../common/Button'
import Select from '../common/Select'
import axios from 'axios'

const Join = ({isOpenJoin, onClose}) => {

  // 아이디 유효성 검사
  const [errorMsg, setErrorMsg] = useState('');

  // 중복확인에 따른 버튼 활성화 state변수
  const [isDisable, setIsDisable] = useState(true);

  // 회원가입 데이터를 저장할 state 변수
  const [joinData, setJoinData] = useState({
    memId: ''
    , memPw: ''
    , checkPw: ''
    , memName: ''
    // 연락처의 폼 요소가 3개인데 db는 하나의 값으로 받기 때문에
    // 배열에 각각의 값을 저장해 전달한다.
    , memTelArr: ['', '', '']
    , memEmail: ''
    // email의 폼 요소가 2개인데 db는 하나의 값으로 받기 때문에 
    // 저장할 키값을 따로 2개 만들어 나중에 memEmail에 저장한다.
    , firstEmail: ''
    , secondEmail: ''
    , memAddr: ''
    , addrDetail: ''
  });

  // 회원가입 데이터를 세팅하는 함수
  const handleJoinData = e => {
    // 이메일을 변경했으면
    if(e.target.name === 'firstEmail' || e.target.name === 'secondEmail'){
      setJoinData({
        ...joinData
        // name엔 memEmail이 없으므로 임의로 만들어서 합쳐줘야 함.
        , [e.target.name]: e.target.value
        // value에 삼항연산자가 가능하다.
        // 폼 요소가 두 개이므로 memEmail에 삼항 연산자로 넣을 수 있다.
        // 변하는 폼 요소를 파악하여 나머지 요소의 값은 그대로 두고 
        // 변하는 값만 변형시킬 수 있는 삼항연산자이다.
        , memEmail: e.target.name === 'firstEmail'
                    ? 
                    e.target.value + joinData.secondEmail 
                    : 
                    joinData.firstEmail + e.target.value  
      });
    }
    // 이메일을 제외한 다른 데이터를 변경했으면
    else{
      setJoinData({
        ...joinData
        , [e.target.name]: e.target.value
      });
    };
  };

  // 회원가입 연락처 배열을 세팅하는 함수
  const handlememTelArrData = (index, e) => {
    // splice는 배열의 한 요소만 변경시킨다.
    // splice함수는 리턴값이 빠져나간 값이므로 state변경 함수에 쓰는 것은 적절하지 않다.
    joinData.memTelArr.splice(index, 1, e.target.value)
    setJoinData({
      ...joinData
      // memTelArr은 함수 사용으로 인해 한 요소만 변경된 상태이므로 배열에 적절한 값이 들어간다.
      , memTelArr: joinData.memTelArr
    });
  };

  // 버튼 클릭 시 회원가입하는 함수
  const join = () => {
    axios.post('/api/members', joinData)
    .then(res => {
      alert('회원가입 성공');
      // 회원가입 성공 시 창을 닫도록 설계
      onClose();
      // 창이 닫힐 때 값을 초기화
      setJoinData({
        memId: ''
        , memPw: ''
        , checkPw: ''
        , memName: ''
        , memTelArr: ['', '', '']
        , memEmail: ''
        , firstEmail: ''
        , secondEmail: ''
        , memAddr: ''
        , addrDetail: ''
      });
    })
    .catch(e => console.log(e));
  };

  // 아이디 중복 확인 함수
  const checkId = () => {
    axios.get(`/api/members/check-id/${joinData.memId}`)
    .then(res => {
      // res.data는 중복확인을 판별하기에 true 혹은 false이다.
      if(res.data){
        alert('사용 가능한 아이디입니다.')
        // 아이디가 사용가능할 때 회원가입 버튼 활성화
        setIsDisable(false);
      }
      else{
        alert('사용 불가능한 아이디입니다.')
      }
    })
    .catch(e => console.log(e));
  };

  return (
    <Modal
     title={'Join'}
     isOpen={isOpenJoin}
     // modal을 직접 건들면 모든 모달에 적용되므로 onclose함수를 여러 줄로 만들어준다.
     onClose={() => {
      setErrorMsg('')
      // onclose가 함수 정의가 됐으므로 props로 전달된 onclose는 호출해준다.
      onClose();
      // 모달을 닫을 때 입력한 값을 초기화하지 않으므로 초기화해주는 state변경함수를 쓴다.
      setJoinData({
        memId: ''
        , memPw: ''
        , checkPw: ''
        , memName: ''
        , memTelArr: ['', '', '']
        , memEmail: ''
        , firstEmail: ''
        , secondEmail: ''
        , memAddr: ''
        , addrDetail: ''
      });
      // 창을 닫을 때도 회원가입 버튼을 비활성화시킨다.
      setIsDisable(true);
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
              // 아이디의 값이 변형될 때마다 유효성 검사를 해야 값을 입력할 때마다 문구가 뜬다.
              // (1): 정규식을 변수에 저장한다.
              const memIdRegex = /^[a-zA-Z0-9]{4,8}$/;
              handleJoinData(e);
              // 중복 안 되는 데이터를 받아도 값이 변경되면 회원가입 버튼을 비활성화
              setIsDisable(true);
              // 유효성 검사의 상태를 나타내는 조건문들
              // e.target.value는 비동기와 상관없이 값이 반영되기 때문에 사용한다.
              // e.target.value의 값을 이용해 truthy, falsy를 판단한다.
              if(!e.target.value){
                setErrorMsg('아이디는 필수입력입니다.')
              }
              else if(e.target.value.length < 4 || e.target.value.length > 8){
                setErrorMsg('아이디는 4~8자입니다.')
              }
              // (2): 정규식에 test함수를 쓴다.
              // (3): 매개변수에 필요한 값을 넣는다.
              // (4): 우리가 정의한 정규식과 일치하면 true 아니면 false를 반환
              else if(!memIdRegex.test(e.target.value)){
                setErrorMsg('아이디는 영문, 숫자만 입력가능합니다.')
              }
              // 위의 경우를 모두 통과하면 유효성 검사를 통과한다.
              else{
                setErrorMsg('')
              }
             }}
            />
            <Button 
             size='25%'
             title='중복 확인'
             color='green'
             onClick={() => {checkId()}}
            />
          </div>
          <p className={styles.error}>{errorMsg}</p>
        </div>
        <div>
          <p>비밀번호</p>
          <Input
           type='password'
           size='100%'
           name='memPw'
           value={joinData.memPw}
           onChange={e => handleJoinData(e)}
          />
        </div>
        <div>
          <p>비밀번호 확인</p>
          <Input 
           type='password'
           size='100%'
           name='checkPw'
           value={joinData.checkPw}
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
            <Input 
             size='100%'
             name='memTelArr'
             // 배열이 들어오는 것이 아닌 배열의 index가 들어와야 하므로 value를 배열의 index로 한다.
             value={joinData.memTelArr[0]}
             // 배열의 한 요소만 바꾸면 되니 그에 맞는 함수를 만들어 실행한다.
             // 매개변수에 각 인덱스를 전해주어 간략하게 함수로 구현할 수 있다.
             onChange={e => handlememTelArrData(0, e)}
            />
            <Input 
             size='100%'
             name='memTelArr'
             value={joinData.memTelArr[1]}
             onChange={e => handlememTelArrData(1, e)}
            />
            <Input 
             size='100%'
             name='memTelArr'
             value={joinData.memTelArr[2]}
             onChange={e => handlememTelArrData(2, e)}
            />
          </div>
        </div>
        <div className={styles.email_div}>
          <p>이메일</p>
          <div>
            <Input 
             size='100%'
             // 입력받는 데이터가 두 개이므로 각각 만들어줬다.
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
              <option>선택</option>
              <option>@gmail.com</option>
              <option>@naver.com</option>
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
            <Input 
             size='100%'
             name='addrDetail'
             value={joinData.addrDetail}
             onChange={e => handleJoinData(e)}
            />
          </div>
        </div>
        <div>
          <Button 
           size='100%'
           title='회원 가입'
           color='green'
           onClick={e => join()}
           // 사용불가 속성(리액트의 disabled는 true, false로 disabled을 실행시킬 수 있다.)
           disabled={isDisable}
          />
        </div>
      </div>
    </Modal>
  )
}

export default Join