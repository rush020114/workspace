import React from 'react'
import styles from './Header.module.css'

const Header = () => {
  return (
    <div className={styles.header_container}>
      <div>회원가입</div>
      <div>로그인</div>
    </div>
  )
}

export default Header