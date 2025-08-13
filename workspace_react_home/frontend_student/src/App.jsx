import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import StuList from './StuList'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <StuList />
    </>
  )
}

export default App
