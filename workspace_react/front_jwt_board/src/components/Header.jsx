import React from 'react'
import styles from './Header.module.css'
import { Link } from 'react-router-dom'

const Header = () => {
  return (
    <div className={styles.header_container}>
      <div>
        <Link to={'/join'}>회원가입</Link>
      </div>
      <div>
        <Link to={'/login'}>로그인</Link>
      </div>
    </div>
  )
}

export default Header