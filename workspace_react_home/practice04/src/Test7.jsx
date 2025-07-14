import { useState } from 'react'
import './Test7.css'

const Test7 = () => {

  const [isShow, setIsShow] = useState(false);

  return(
    <div className='test7_container'>
      {/* 명령한 이벤트에서만 state변경 함수가 실행될 것이니 다른 이벤트 속성은 영향을 받지 않는다. */}
      <div className='top' onMouseEnter={() => setIsShow(!isShow)} onMouseLeave={() => setIsShow(!isShow)}>마우스를 올리면 숨겨진 글자가 보여요.</div>
      {isShow ? <div className='bottom'>Hello React!</div> : null}
    </div>
  )
}

export default Test7