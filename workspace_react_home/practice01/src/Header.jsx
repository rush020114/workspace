// jsx파일은 컴포넌트로 쓸 것이기 때문에 컴포넌트명과 대소문자를 똑같이 해서 사용한다.
// rafce는 react arrow function component export의 줄인말로 component생성을 도와주는 명령어이다.
// 컴포넌트를 따로 만들었으면 export를 해주어 app컴포넌트에서 사용할 수 있게 해주어야 한다.
const Header = () => {
  return (
    <div>Header</div>
  )
}

export default Header;