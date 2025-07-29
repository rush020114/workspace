import axios from "axios"
import { useEffect, useState } from "react"
import './MemberList.css'

const MemberList = () => {

  const [memberList, setMemberList] = useState([])

  useEffect(() => {
    axios.get('/api/test3')
    .then(res => {
      console.log(res.data)
      setMemberList(res.data)
    })
    .catch(error => console.log(error))
  }, [])

  return(
    <div className="member-container">
      <table className="member-table">
        <colgroup>
          <col width='33%' />
          <col width='34%' />
          <col width='33%' />
        </colgroup>
        <thead>
          <tr>
            <td>아이디</td>
            <td>이름</td>
            <td>나이</td>
          </tr>
        </thead>
        <tbody>
          {
            memberList.map((e, i) => {
              return(
                <tr key={i}>
                  <td>{e.memId}</td>
                  <td>{e.memName}</td>
                  <td>{e.memAge}</td>
                </tr>
              )
            })
          }
        </tbody>
      </table>
    </div>
  )
}

export default MemberList