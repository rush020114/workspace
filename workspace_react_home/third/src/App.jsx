import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
// 다른 파일의 컴포넌트를 가져오기 위해
// import를 사용한다.
import Footer from './Footer'
import Table from './Table'

function App() {

  // 컴포넌트를 만들기만 해서는 화면에 구현되지 않는다. 사용을 위해 app컴포넌트에서 태그로 호출한다.
  // 사실 컴포넌트는 한 파일에 하나만 쓰기를 권장한다.
  // 다른 파일은 src폴더 안에 만들어야 한다.
  const Header = () => {
    return (
      <div>헤더 영역</div>
    )
  }

  return (
    <>
      <Header></Header>
      <Table></Table>
      <div>이곳은 메인페이지입니다.</div>
      <Footer></Footer>
    </>
  )
}

export default App
