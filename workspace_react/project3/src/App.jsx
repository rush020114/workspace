import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Test1 from './Test1'
import Test2 from './Test2'
import Test3 from './Test3'
import Test4 from './Test4'
import Test5 from './Test5'
import CartList from './CartList'

function App() {

  const arr = [1, 3, 5];

  return (
    <>
      {/* <Test1 /> */}
      {/* <Test2 /> */}
      {/* <Test3 /> */}
      {/* <Test4 /> */}
      {/* <Test5 /> */}

      <CartList />

      {
        arr.map((e, i) => {
          return(
            <div key={i}>{e}</div>
          )
        })
      }

    </>
  )
}

export default App
