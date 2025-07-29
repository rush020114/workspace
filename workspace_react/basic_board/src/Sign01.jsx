import axios from 'axios'
import React, { useState } from 'react'

const Sign01 = () => {

  const [memberData, setMemberData] = useState({
    memId: ''
    , memPw: ''
    , checkPw: ''
    , memName: ''
    , memAge: ''
  })

  const handleMemberData = e => {
    setMemberData({
      ...memberData,
      [e.target.name]: e.target.value
    })
  }

  const regMember = () => {
    if(memberData.memPw !== memberData.checkPw){
      alert('비밀번호를 확인하세요.')
      return;
    }
    axios.post('/api/members', memberData)
    .then(res => alert('등록성공'))
    .catch(error => console.log(error))
  }

  console.log(memberData)

  return (
    <div>
      <div>
        <p>아이디</p>
        <input
         type="text" 
         value={memberData.memId}
         name='memId'
         onChange={e => handleMemberData(e)}
         />
      </div>
      <div>
        <p>비밀번호</p>
        <input
         type="password" 
         value={memberData.memPw}
         name='memPw'
         onChange={e => handleMemberData(e)}
         />
      </div>
      <div>
        <p>비밀번호 확인</p>
        <input
         type="password" 
         value={memberData.checkPw}
         name='checkPw'
         onChange={e => handleMemberData(e)}
         />
      </div>
      <div>
        <p>이름</p>
        <input
         type="text" 
         value={memberData.memName}
         name='memName'
         onChange={e => handleMemberData(e)}
         />
      </div>
      <div>
        <p>나이</p>
        <input
         type="text" 
         value={memberData.memAge}
         name='memAge'
         onChange={e => handleMemberData(e)}
         />
      </div>
      <div>
        <button
         type='button'
         onClick={e => regMember()}
        >등록</button>
      </div>
    </div>
  )
}

export default Sign01