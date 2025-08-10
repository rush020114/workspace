  import { useState } from 'react'
  import reactLogo from './assets/react.svg'
  import viteLogo from '/vite.svg'
  import './App.css'
  import { Route, Routes, useNavigate } from 'react-router-dom'
  import ItemList from './ItemList'
  import ItemDetail from './ItemDetail'
  import RegForm from './RegForm'
  import UpdateForm from './UpdateForm'

  function App() {

    const nav = useNavigate();

    return (
      <>
        <Routes>
          <Route
          path='/' 
          element={<ItemList nav={nav} />} 
          />
          <Route
          path='/detail/:itemNum' 
          element={<ItemDetail nav={nav} />} 
          />
          <Route
          path='/reg' 
          element={<RegForm nav={nav} />} 
          />
          <Route
          path='/update/:itemNum' 
          element={<UpdateForm nav={nav} />} 
          />
        </Routes>
      </>
    )
  }

  export default App
