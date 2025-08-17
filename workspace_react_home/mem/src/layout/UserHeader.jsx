import React, { useState } from 'react'
import styles from './UserHeader.module.css'
import Login from '../components/Login'

const UserHeader = () => {

  const [isOpenLogin, setIsOpenLogin] = useState(false);

  return (
    <div className={styles.header}>
      <div className={styles.menu_div}>
        <h3>MEM</h3>
        <div>
          <p onClick={e => setIsOpenLogin(true)}>login</p>
          <p>sign up</p>
        </div>
      </div>
      <Login 
       isOpenLogin={isOpenLogin}
       setIsOpenLogin={() => setIsOpenLogin(false)}
      />
    </div>
  )
}

export default UserHeader