import React from 'react'
import styles from './CarHeader.module.css'
import { NavLink, useNavigate } from 'react-router-dom'

const CarHeader = () => {

  const nav = useNavigate();

  return (
    <div className={styles.container}>
      <ul className={styles.menu}>
        <li onClick={() => nav('/')}>
          <NavLink>홈</NavLink>
        </li>
        <li onClick={() => nav('/manage-car')}>
          차량관리
        </li>
        <li onClick={() => nav('/reg-sales')}>
          판매정보등록
        </li>
        <li onClick={() => nav('/sales-info')}>
          판매목록조회
        </li>
      </ul>
    </div>
  )
}

export default CarHeader