import { useState } from "react"

const Select2 = () => {

  const [memberInfo, setMemberInfo] = useState({
    name: '',
    age: '',
    grade: '1'
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
      <table>
        <tbody>
          <tr>
            <td>이름</td>
            <td>
              <input
               type="text"
               value={memberInfo.name} 
               name="name" 
               onChange={e => handleMemberInfo(e)}
              />
            </td>
          </tr>
          <tr>
            <td>나이</td>
            <td>
              <input
               type="text" 
               value={memberInfo.age}
               name="age"
               onChange={e => handleMemberInfo(e)}
               />
            </td>
          </tr>
          <tr>
            <td>학년</td>
            <td>
              <select 
               value={memberInfo.grade}
               name="grade"
               onChange={e => handleMemberInfo(e)}
              >
                <option value="1">1학년</option>
                <option value="2">2학년</option>
                <option value="3">3학년</option>
                <option value="4">4학년</option>
              </select>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  )
}

export default Select2