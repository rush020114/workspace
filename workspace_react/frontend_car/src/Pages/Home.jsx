import React from 'react'
import styles from './Home.module.css'

const Home = () => {
  return (
    <div className={styles.container}>
      <span className={styles.content}><i className="bi bi-car-front"></i></span>
      <p>차량 판매 정보 시스템</p>
    </div>
  )
}

export default Home