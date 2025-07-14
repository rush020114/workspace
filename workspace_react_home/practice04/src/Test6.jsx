import { useState } from "react"
import './Test6.css'

const Test6 = () => {

  const [cnt, setCnt] = useState(0);

  return(
    <div className="test6_container">
        <h1>Simple Counter</h1>
      <div>
        <p>현재 카운트 : </p>
        <h2>{cnt}</h2>
      </div>
      <div>
         <button type="button" onClick={() => setCnt(cnt - 1)}>-1</button>
         <button type="button" onClick={() => setCnt(cnt - 10)}>-10</button>
         <button type="button" onClick={() => setCnt(cnt - 100)}>-100</button>
         <button type="button" onClick={() => setCnt(cnt + 100)}>+100</button>
         <button type="button" onClick={() => setCnt(cnt + 10)}>+10</button>
         <button type="button"onClick={() => setCnt(cnt + 1)}>+1</button>
      </div>
    </div>
  )
}

export default Test6