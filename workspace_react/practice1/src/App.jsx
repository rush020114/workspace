import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Header from './Header'
import Content from './Content'
import Footer from './Footer'
function App() {

  return (
    <>
      <div style={{border: '1px solid black', width: '600px', padding: '30px', margin: '50px auto'}}>
        <Header />
        <Content />
        <Footer />
      </div>
    </>
  )
}

export default App
