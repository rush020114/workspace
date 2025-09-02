import React from 'react'
import styles from './CarHeader.module.css'
import { NavLink, useNavigate } from 'react-router-dom'

const CarHeader = () => {

  const nav = useNavigate();

  return (
    <div className={styles.container}>
      <ul className={styles.menu}>
        <li>
          <NavLink
            to={'/'}
          >홈</NavLink>
        </li>
        <li>
          <NavLink
            to={'/manage-car'}
          >차량관리</NavLink>
        </li>
        <li>
          <NavLink
            to={'/reg-sales'}
          >판매정보등록</NavLink>
        </li>
        <li>
          <NavLink
            to={'sales-info'}
          >판매목록조회</NavLink>
        </li>
      </ul>
    </div>
  )
}

export default CarHeader