import axios from "axios";
import { useState } from "react"

const InputTest02 = () => {

  const [userInfo, setUserInfo] = useState({
    id: '',
    pw: '',
    name: '',
    addr: ''
  });

  console.log(userInfo)

  const handleInputUser = e => {
    setUserInfo({
      ...userInfo,
      [e.target.name]: e.target.value
    })
  }

  const regUser = () => {
    axios.post('api/users', userInfo)
    .then(res => console.log(res.data))
    .catch(error => console.log(error))
  }

  return(
    <div>
      <table>
        <tbody>
          <tr>
            <td>아이디:</td>
            <td>
              <input type="text"
               name="id"
               value={userInfo.id}
               onChange={e => handleInputUser(e)}
              />
            </td>
          </tr>
          <tr>
            <td>비밀번호:</td>
            <td>
              <input type="text"
               name="pw" 
               value={userInfo.pw}
               onChange={e => handleInputUser(e)}
              />
            </td>
          </tr>
          <tr>
            <td>이름:</td>
            <td>
              <input type="text"
               name="name" 
               value={userInfo.name}
               onChange={e => handleInputUser(e)}
              />
            </td>
          </tr>
          <tr>
            <td>주소:</td>
            <td>
              <input type="text"
               name="addr" 
               value={userInfo.addr}
               onChange={e => handleInputUser(e)}
              />
            </td>
          </tr>
        </tbody>
      </table>
      <button 
       type="button"
       onClick={e => regUser()}
      >등록</button>
    </div>
  )
}

export default InputTest02