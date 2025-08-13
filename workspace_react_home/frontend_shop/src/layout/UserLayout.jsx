import React from 'react'
import styles from './UserLayout.module.css'
import UserHeader from './UserHeader'
import { Outlet } from 'react-router-dom'

// 일반 유저가 보는 화면의 레이아웃을 구성하는 컴포넌트
const UserLayout = () => {
  return (
    <div className={styles.container}>
      <div className={styles.header_div}>
        {/* user가 보는 header */}
        <UserHeader />
      </div>
      <div>
        {/* 
         userLayout이 실행될 때 같이 띄우고 싶은 page는
         Outlet을 함께 써야 한다.
         outlet은 Route안의 Route가 어디에 그려질 것인지 정해준다.
        */}
        <Outlet />
      </div>
    </div>
  )
}

export default UserLayout