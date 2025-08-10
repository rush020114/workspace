import React, { useEffect, useState } from 'react'
import styles from './SignUp.module.css'

const SignUp = () => {

  useEffect(() => {
    const [regMember, setRegMember] = useState({
    memId: ''
    , memPw: ''
    , checkPw: ''
    , memName: ''
    , memGender: ''
    , memAddr1: ''
    , memAddr2: ''
    , memAddr: memAddr
    , memTel1: '010'
    , memTel2: ''
    , memTel3: ''
    , memTel: memTel
    , memIden1: ''
    , memIden2: ''
    , memIden: memIden
    , memEmail1: ''
    , memEmail2: ''
    , memEmail: memEmail
  })
  }, [regMember])

  const memAddr = `${regMember.memAddr1} ${regMember.memAddr2}`;
  const memTel = `${regMember.memTel1}-${regMember.memTel2}-${regMember.memTel3}`;
  const memIden = `${regMember.memIden1}-${regMember.memIden2}`;
  const memEmail = `${regMember.memEmail1}@${regMember.memEmail2}`;

  const handleRegMember = e => {
    setRegMember({
      ...regMember
      , [e.target.name]: e.target.value
    })
  }

  console.log(regMember)

  return (
    <div className={styles.container}>
      <div className={styles.title}>
        <h2>회원가입</h2>
        <p><span>*</span> 필수입력사항</p>
      </div>
      <table className={styles.table}>
        <colgroup>
          <col width='20%' />
          <col width='80%' />
        </colgroup>
        <tbody>
          <tr>
            <td>아이디 <span>*</span></td>
            <td>
              <input
               type="text" 
               name='memId'
               value={regMember.memId}
               onChange={e => handleRegMember(e)}
              />
            </td>
          </tr>
          <tr>
            <td>비밀번호 <span>*</span></td>
            <td>
              <input
               type="text" 
               name='memPw'
               value={regMember.memPw}
               onChange={e => handleRegMember(e)}
              />
            </td>
          </tr>
          <tr>
            <td>비밀번호 확인 <span>*</span></td>
            <td>
              <input
               type="text" 
               name='checkPw'
               value={regMember.checkPw}
               onChange={e => handleRegMember(e)}
              />
            </td>
          </tr>
          <tr>
            <td>이름 <span>*</span></td>
            <td>
              <input
               type="text" 
               name='memName'
               value={regMember.memName}
               onChange={e => handleRegMember(e)}
              />
            </td>
          </tr>
          <tr>
            <td>성별 <span>*</span></td>
            <td>
              <div>
                <input
                 type="radio" 
                 name='memGender'
                 value={'남'}
                 checked={regMember.memGender === '남'}
                 onChange={e => handleRegMember(e)}
                />
                <p>남</p>
                <input
                 type="radio" 
                 name='memGender'
                 value={'여'}
                 checked={regMember.memGender === '여'}
                 onChange={e => handleRegMember(e)}
                />
                <p>여</p>
              </div>
            </td>
          </tr>
          <tr>
            <td>주소</td>
            <td>
              <select
               name="memAddr1"
               value={regMember.memAddr1}
               onChange={e => handleRegMember(e)}
              >
                <option value="">선택</option>
                <option value="서울">서울</option>
                <option value="인천">인천</option>
                <option value="대전">대전</option>
                <option value="대구">대구</option>
                <option value="광주">광주</option>
                <option value="부산">부산</option>
                <option value="울산">울산</option>
              </select>
              <input
               type="text" 
               name='memAddr2'
               value={regMember.memAddr2}
               onChange={e => handleRegMember(e)}
              />
            </td>
          </tr>
          <tr>
            <td>전화번호 <span>*</span></td>
            <td>
              <select
               type="text" 
               name='memTel1'
               value={regMember.memTel1}
               onChange={e => handleRegMember(e)}
              >
                <option value="010">010</option>
                <option value="011">011</option>
                <option value="012">012</option>
                <option value="013">013</option>
                <option value="014">014</option>
              </select>
              <input
               type="text" 
               name='memTel2'
               value={regMember.memTel2}
               onChange={e => handleRegMember(e)}
              />
              <input
               type="text" 
               name='memTel3'
               value={regMember.memTel3}
               onChange={e => handleRegMember(e)}
              />
            </td>
          </tr>
          <tr>
            <td>주민등록번호 <span>*</span></td>
            <td>
              <input
               type="text" 
               name='memIden1'
               value={regMember.memIden1}
               onChange={e => handleRegMember(e)}
              />
              -
              <input
               type="text" 
               name='memIden2'
               value={regMember.memIden2}
               onChange={e => handleRegMember(e)}
              />
            </td>
          </tr>
          <tr>
            <td>이메일</td>
            <td>
              <input
               type="text" 
               name='memEmail1'
               value={regMember.memEmail1}
               onChange={e => handleRegMember(e)}
              />
              @
              <select
               type="text" 
               name='memEmail2'
               value={regMember.memEmail2}
               onChange={e => handleRegMember(e)}
              >
                <option value="">선택</option>
                <option value="gmail.com">gmail.com</option>
                <option value="naver.com">naver.com</option>
                <option value="kakao.com">kakao.com</option>
              </select>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default SignUp