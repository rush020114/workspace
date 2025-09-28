import React from 'react'
import UserHeader from './UserHeader.jsx'
import styles from './UserLayout.module.css'
import { Outlet } from 'react-router-dom'

const UserLayout = ({onLogin, onLogout, notiCnt}) => {
  return (
    <div className={styles.container}>
      <div className={styles.header}>
        <UserHeader 
          onLogin={onLogin}
          onLogout={onLogout}
          notiCnt={notiCnt}
        />
      </div>
      <div className={styles.content}>
        <Outlet />
      </div>
    </div>
  )
}

export default UserLayout