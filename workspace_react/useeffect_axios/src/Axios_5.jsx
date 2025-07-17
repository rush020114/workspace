import axios from 'axios'
import React, { useEffect, useState } from 'react'


const Axios_5 = () => {
  const [classList, setClassList] = useState([]);
  const [hobbyList, setHobbyList] = useState([]);

  useEffect(() => {
    axios.get('/api/getClass')
    .then((res) => {
      console.log(res.data)
      setClassList(res.data)
    })
    .catch((error) => {console.log(error)})

    axios.get('/api/getHobby')
    .then((res) => {
      console.log(res.data)
      setHobbyList(res.data)
    })
    .catch((error) => {console.log(error)})
  }, [])

  return (
    <div>
      <select>
        <option>반 선택</option>
        {
          classList.map((class1, i) => {
            return(
              <option key={i}>{class1}</option>
            )
          })
        }
      </select>
      <div>
        {
          hobbyList.map((hobby, i) => {
            return(
              <span key={i}>
                <input type="checkbox"/> {hobby}
              </span>
            )
          })
        }
      </div>
    </div>
  )
}

export default Axios_5