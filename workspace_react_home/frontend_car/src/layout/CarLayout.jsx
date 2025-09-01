import React from 'react'
import styles from './CarLayout.module.css'
import { CarHeader } from './CarHeader'
import { Outlet } from 'react-router-dom'

const CarLayout = () => {
  return (
    <div className={styles.container}>
      <div className={styles.header}>
        <CarHeader />
      </div>
      <div className={styles.content}>
        <Outlet />
      </div>
    </div>
  )
}

export default CarLayout