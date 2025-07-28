import axios from 'axios'
import React, { useState } from 'react'

const SignUp = () => {

  const [memberData, setMemberData] = useState({
    memId: ''
    , memPw: ''
    , memName: ''
    , memAge: ''
  })

  const handleMemberData = e => {
    setMemberData({
      ...memberData
      , [e.target.name]: e.target.value
    })
  }

  const [checkPw, setCheckPw] = useState('')

  const insertMember = () => {
    axios.post('/api/members', memberData)
    .then(res => alert('등록성공'))
    .catch(error => console.log(error))
  }

  const updateMember = () => {
    axios.put(`/api/members/${memberData.memId}`, memberData)
    .then(res => res.data === 0 ? alert('일치하는 아이디가 없습니다.') : alert('수정성공'))
    .catch(error => console.log(error))
  }

  const deleteMember = () => {
    axios.delete(`/api/members/${memberData.memId}`)
    .then(res => res.data === 0 ? alert('일치하는 아이디가 없습니다.') : alert('삭제 성공'))
    .catch(error => console.log(error))
  }

  console.log(memberData, checkPw)

  return (
    <div>
      <div>
        <p>아이디</p>
        <input
         type="text" 
         name='memId'
         value={memberData.memId}
         onChange={e => handleMemberData(e)}
         />
      </div>
      <div>
        <p>비밀번호</p>
        <input
         type="password" 
         name='memPw'
         value={memberData.memPw}
         onChange={e => handleMemberData(e)}
         />
      </div>
      <div>
        <p>비밀번호 확인</p>
        <input
         type="password" 
         name='checkPw'
         value={checkPw}
         onChange={e => setCheckPw(e.target.value)}
         />
      </div>
      <div>
        <p>이름</p>
        <input
         type="text" 
         name='memName'
         value={memberData.memName}
         onChange={e => handleMemberData(e)}
         />
      </div>
      <div>
        <p>나이</p>
        <input
         type="text" 
         name='memAge'
         value={memberData.memAge}
         onChange={e => handleMemberData(e)}
        />
      </div>
      <div>
        <button
         type='button'
         onClick={e => memberData.memPw === checkPw ? insertMember() : alert('비밀번호가 일치하지 않습니다.')}
        >등록</button>
        <button
         type='button'
         onClick={e => updateMember()}
        >수정</button>
        <button
         type='button'
         onClick={e => deleteMember()}
        >삭제</button>
      </div>
    </div>
  )
}

export default SignUp