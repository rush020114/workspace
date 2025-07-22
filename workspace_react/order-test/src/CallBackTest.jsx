import React from 'react'

const CallBackTest = () => {

  const test = () => {
    alert(1)
  }

  const ccc = () => {
    alert(11)
    return 10
  }

  //const d = ccc() // ccc함수 실행 후 10을 d에 리턴한다.
  const d1 = ccc // ccc함수 참조값을 받는다.

  return (
    <div>
      {/* 함수의 참조값을 onClick에 저장 */}
      <button type='button' onClick={() => test()}>버튼1</button>
      {/* 함수의 주소값만 onClick에 저장 */}
      <button type='button' onClick={test}>버튼2</button>
      {/* test() 함수의 실행 후 리턴값이 onClick에 저장 */}
      {/* <button type='button' onClick={test()}>버튼3</button> */}
    </div>
  )
}

export default CallBackTest