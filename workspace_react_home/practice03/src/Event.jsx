

const Event = () => {
  // 이벤트 : 웹에서 어떤 행동을 할 때 발생되는 모든 것
  // 이벤트 핸들링 : 이벤트를 다루는 것
  // 이벤트를 실행할 속성에 함수 자체를 넣어버리면 이벤트 코드를 손쉽게 짤 수 있다.
  const btn = '버튼'

  const f1 = () => alert('버튼 클릭')
  

  return (
    <button type="button" onClick={() => {f1()}}>{btn}</button>
  )
}

export default Event