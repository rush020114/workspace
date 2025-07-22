import axios from "axios"
import { useState } from "react"
import './InputTest6.css'

const InputTest6 = () => {

  const [memberInfo, setMemberInfo] = useState({
    id: '',
    pw: '',
    checkPw: '',
    emailAddr: '',
    name: '',
    idenNum1: '',
    idenNum2: '',
    year: '',
    month: '',
    day: '',
    addr: '',
    addr1: '',
    addr2: '',
    introduce: ''
  })

  const handleInputdata = (e) => {
    setMemberInfo({
      ...memberInfo,
      [e.target.name]: e.target.value
    })
  }

  const regMember = () => {
    axios
    .post('/api/members', memberInfo)
    .then(res => console.log(res.data))
    .catch(error => console.log(error))
  }

  console.log(memberInfo)

  return(
    <div className="input6-container">
      <table className="input6-table">
        <colgroup>
          <col width='20%' />
          <col width='80%' />
        </colgroup>
        <tbody>
          <tr>
            <td colSpan={2}>
              <span className="title-span">{'('}필수입력{')'}</span>회원 기본 정보
            </td>
          </tr>
          <tr>
            <td>아이디:</td>
            <td>
              <div className="flex-div">
                <input
                 type="text" 
                 placeholder="4~12자의 영문 대소문자, 숫자로만 입력하세요." 
                 name="id"
                 value={memberInfo.id}
                 onChange={e => handleInputdata(e)}
                 />
                <button type="button">아이디 검사</button>
              </div>
            </td>
          </tr>
          <tr>
            <td>비밀번호:</td>
            <td>
              <div className="flex-div">
                <input 
                 type="password"
                 name="pw"
                 value={memberInfo.pw} 
                 onChange={e => handleInputdata(e)}
                 />
                <div>4~12자의 영문 대소문자, 숫자로만 입력하세요.</div>
              </div>
            </td>
          </tr>
          <tr>
            <td>비밀번호 확인:</td>
            <td>
              <div className="flex-div">
                <input
                 type="password" 
                 name="checkPw"
                 value={memberInfo.checkPw} 
                 onChange={e => handleInputdata(e)}
                 />
                <button>비밀번호 확인</button>
              </div>
            </td>
          </tr>
          <tr>
            <td>메일주소:</td>
            <td>
              <div className="flex-div">
                <input
                 type="text"
                 name="emailAddr"
                 value={memberInfo.emailAddr}  
                 onChange={e => handleInputdata(e)}
                 />
                <button>메일 확인</button>
                <div>예{')'}id@domain.com</div> 
              </div>     
            </td>
          </tr>
          <tr>
            <td>이름:</td>
            <td>
              <input
               type="text"
               name="name"
               value={memberInfo.name} 
               onChange={e => handleInputdata(e)}
               />
            </td>
          </tr>
          <tr>
            <td colSpan={2}>개인 신상 정보</td>
          </tr>
          <tr>
            <td>주민등록번호:</td>
            <td>
              <div className="flex-div">
                <input
                 type="text" 
                 name="idenNum1"
                 value={memberInfo.idenNum1}
                 onChange={e => handleInputdata(e)}
                 />-
                <input
                 type="password" 
                 name="idenNum2"
                 value={memberInfo.idenNum2}
                 onChange={e => handleInputdata(e)}
                 />
                 <button type="button">확인</button>
                 <p>예{')'} 123456-1234567</p>
              </div>
            </td>
          </tr>
          <tr>
            <td>생일:</td>
            <td>
              <input
               type="text"
               name="year"
               value={memberInfo.year} 
               onChange={e => handleInputdata(e)}
               />년
              <input
               type="text" 
               name="month"
               value={memberInfo.month}
               onChange={e => handleInputdata(e)}
               />월
              <input 
               type="text" 
               name="day"
               value={memberInfo.day}
               onChange={e => handleInputdata(e)}
               />일
            </td>
          </tr>
          <tr>
            <td>주소:</td>
            <td>
              <div className="flex-div">
                <input
                 type="text"
                 name="addr"
                 value={memberInfo.addr} 
                 onChange={e => handleInputdata(e)}
                 />
                <button type="button">우편번호 찾기</button>
              </div>
              <input
               type="text" 
               name="addr1"
               value={memberInfo.addr1}               
               onChange={e => handleInputdata(e)}
               />
              <input
               type="text" 
               name="addr2"
               value={memberInfo.addr2}
               onChange={e => handleInputdata(e)}
               />
            </td>
          </tr>
          <tr>
            <td>관심분야:</td>
            <td>
              <input type="checkbox" />컴퓨터
              <input type="checkbox" />인터넷
              <input type="checkbox" />여행
              <input type="checkbox" />영화감상
              <input type="checkbox" />음악감상
            </td>
          </tr>
          <tr>
            <td>자기소개:</td>
            <td><textarea
             rows={5}
             name="introduce"
             value={memberInfo.introduce}
             onChange={e => handleInputdata(e)}
             ></textarea></td>
          </tr>
        </tbody>
      </table>
      <div className="btn-div">
        <button type="button" onClick={e => regMember()}>회원등록</button>
        <button type="button">다시입력</button>
      </div>
    </div>
  )
}

export default InputTest6