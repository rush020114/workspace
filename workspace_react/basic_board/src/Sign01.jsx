import axios from 'axios'
import React, { useState } from 'react'

const Sign01 = () => {

  const [memberData, setMemberData] = useState({
    memId: ''
    , memPw: ''
    , memName: ''
    , memAge: ''
  })

  const [checkPw, setCheckPw] = useState('')

  const handleMemberData = e => {
    setMemberData({
      ...memberData,
      [e.target.name]: e.target.value
    })
  }

  const regMember = () => {
    axios.post('/api/members', memberData)
    .then(res => console.log(res.data))
    .catch(error => console.log(error))
  }

  console.log(memberData)
  console.log(checkPw)

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
         value={checkPw}
         name='checkPw'
         onChange={e => setCheckPw(e.target.value)}
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
         onClick={memberData.memPw === checkPw ? e => regMember() : () => alert("비밀번호가 일치하지 않습니다.")}
        >등록</button>
      </div>
    </div>
  )
}

export default Sign01