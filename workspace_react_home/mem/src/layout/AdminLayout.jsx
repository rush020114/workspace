import React from 'react'
import styles from './AdminLayout.module.css'
import AdminSideMenu from './AdminSideMenu'
import { Outlet } from 'react-router-dom'

const AdminLayout = () => {
  return (
    <div className={styles.container}>
      <div className={styles.header_div}>헤더</div>
      <div className={styles.main}>
        <div className={styles.side}>
          <AdminSideMenu />
        </div>
        <div className={styles.content}>
          <Outlet />
        </div>
      </div>
    </div>
  )
}

export default AdminLayout