import React from 'react'
import styles from './AdminSideMenu.module.css'

const AdminSideMenu = () => {
  return (
    <div className={styles.container}>
      <div className={styles.menu_category}>
        <p>
          <span>
            <i className="bi bi-bag-fill"></i>
          </span>
          상품관리
        </p>
        <ul className={styles.side_menu}>
          <li>카테고리관리</li>
          <li className={styles.active}>도서등록</li>
          <li>도서관리</li>
        </ul>
      </div>
      <div className={styles.menu_category}>
        <p>
          <span>
            <i className="bi bi-person-lines-fill"></i>
          </span>
          고객관리
        </p>
        <ul className={styles.side_menu}>
          <li>고객정보관리</li>
          <li>고객정보변경</li>
          <li>게시판관리</li>
        </ul>
      </div>
      <div className={styles.menu_category}>
        <p>
          <span>
            <i className="bi bi-clipboard-data-fill"></i>
          </span>
          매출관리
        </p>
        <ul className={styles.side_menu}>
          <li>월별매출관리</li>
          <li>주간매출관리</li>
          <li>연간매출관리</li>
        </ul>
      </div>
    </div>
  )
}

export default AdminSideMenu