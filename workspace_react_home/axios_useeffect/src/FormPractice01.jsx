import { useState } from "react"

const FormPractice01 = () => {

  const [memberInfo, setMemberInfo] = useState({
    name: '',
    age: 20,
    idenNum: '',
    gender: '',
    addr: '1',
    intro: ''
  })

  console.log(memberInfo)

  const handleMemberInfo = e => {
    setMemberInfo({
      ...memberInfo,
      [e.target.name]: e.target.value
    })
  }

  return(
    <div>
      <div>
        <p>이름</p>
        <input
         type="text" 
         value={memberInfo.name}
         name="name"
         onChange={e => handleMemberInfo(e)}
         />
      </div>
      <div>
        <p>나이</p>
        <input
         type="number" 
         value={memberInfo.age}
         name="age"
         onChange={e => handleMemberInfo(e)}
         />
      </div>
      <div>
        <p>주민등록번호</p>
        <input
         type="password" 
         name="idenNum"
         value={memberInfo.idenNum}
         onChange={e => handleMemberInfo(e)}
         />
      </div>
      <div>
        <p>성별</p>
        <input
         type="radio" 
         value={'M'}
         name="gender"
         checked={memberInfo.gender === 'M'}
         onChange={e => handleMemberInfo(e)}
         /> 남
        <input
         type="radio"
         value={'F'} 
         name="gender"
         checked={memberInfo.gender === 'F'}
         onChange={e => handleMemberInfo(e)}
        /> 여
      </div>
      <div>
        <p>주소</p>
        <select
         value={memberInfo.addr}
         name="addr"
         onChange={e => handleMemberInfo(e)}
         >
          <option value="1">울산</option>
          <option value="2">부산</option>
          <option value="3">서울</option>
        </select>
      </div>
      <div>
        <p>소개</p>
        <textarea
         rows={5}
         cols={80}
         value={memberInfo.intro}
         name="intro"
         onChange={e => handleMemberInfo(e)}
        ></textarea>
      </div>
    </div>
  )
}

export default FormPractice01