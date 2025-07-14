import React, { useState } from 'react'
import './Test1.css' // ./는 현폴더라는 의미이다.

const Test1 = () => {
  const [cnt, setCnt] = useState(0);
  console.log(cnt);
  return (
    <div className='test1_container'>
      <div>{cnt}</div>
      <button type='button' onClick={() => setCnt(cnt + 1)}>클릭</button>
    </div>
  )
}
export default Test1