import React from 'react'
import styles from './UserHeader.module.css'

const UserHeader = () => {
  return (
    <div className={styles.container}>
      <div className={styles.login_div}>
        <span>LOGIN</span>
        <span>JOIN</span>
      </div>
      {/* 이미지 검색은 public을 기준으로 삼기 때문에 public 폴더 안에 있는 사진의 파일명을 현재폴더로 잡고 입력한다. */}
      <div className={styles.banner_div}>
        <img
         className={styles.banner_img}
         src="./book_banner.PNG" 
        />
        <p>BOOK SHOP</p>
      </div>
      <div className={styles.menu_div}>
        메뉴자리
      </div>
    </div>
  )
}

export default UserHeader