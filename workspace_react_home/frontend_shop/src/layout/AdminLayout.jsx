import React from 'react'
import styles from './AdminLayout.module.css'

const AdminLayout = () => {
  return (
    <div className={styles.container}>
      <div className={styles.header_div}>헤더</div>
      <div className={styles.main}>
        <div className={styles.side_div}>사이드</div>
        <div className={styles.content}></div>
      </div>
    </div>
  )
}

export default AdminLayout