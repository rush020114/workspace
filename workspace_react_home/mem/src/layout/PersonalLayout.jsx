import React from 'react'
import styles from './PersonalLayout.module.css'
import AdminSideMenu from './AdminSideMenu'
import { Outlet } from 'react-router-dom'
import UserHeader from './UserHeader'

const PersonalLayout = ({notiCnt, onResetCnt}) => {
  return (
    <div className={styles.container}>
      <div className={styles.header_div}>
        <UserHeader />
      </div>
      <div className={styles.main}>
        <div className={styles.side}>
          <AdminSideMenu 
            notiCnt={notiCnt}
            onResetCnt={onResetCnt}
          />
        </div>
        <div className={styles.content}>
          <Outlet context={{notiCnt}} />
        </div>
      </div>
    </div>
  )
}

export default PersonalLayout