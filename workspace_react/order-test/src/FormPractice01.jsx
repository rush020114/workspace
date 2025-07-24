import React, { useState } from 'react'

const FormPractice01 = () => {

  const [memberInfo, setMemberInfo] = useState({
    id: '',
    pw: '',
    hobby: '1',
    gender: '',
    content: ''
  })

  console.log(memberInfo)

  const handleMemberInfo = e => {
    setMemberInfo({
      ...memberInfo,
      [e.target.name]: e.target.value
    })
  }

  return (
    <div>
      <table>
        <tbody>
          <tr>
            <td>아이디</td>
            <td>
              <input
               type="text"
               name='id'
               value={memberInfo.id}
               onChange={e => handleMemberInfo(e)}
               />
            </td>
          </tr>
          <tr>
            <td>비번</td>
            <td>
              <input
               type="password" 
               name='pw'
               value={memberInfo.pw}
               onChange={e => handleMemberInfo(e)}
               />
            </td>
          </tr>
          <tr>
            <td>취미</td>
            <td>
              <select
               value={memberInfo.hobby}
               name="hobby"
               onChange={e => handleMemberInfo(e)}
              >
                <option
                 value="1"
                 >운동</option>
                <option
                 value="2"
                 >게임</option>
                <option
                 value="3"
                 >취미</option>
              </select>
            </td>
          </tr>
          <tr>
            <td>성별</td>
            <td>
              남<input
               type="radio" 
               value={'M'}
               name='gender'
               checked={memberInfo.gender === 'M'}
               onChange={e => handleMemberInfo(e)}
               />
              여<input
               type="radio"
               value={'F'} 
               name='gender'
               checked={memberInfo.gender === 'F'}
               onChange={e => handleMemberInfo(e)}
               />
            </td>
          </tr>
          <tr>
            <td>인사말</td>
            <td>
              <textarea
               rows={5}
               value={memberInfo.content}
               name="content"
               onChange={e => handleMemberInfo(e)}
              ></textarea>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default FormPractice01