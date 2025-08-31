import React from 'react'
import styles from './AdminSideMenu.module.css'
import { useLocation } from 'react-router-dom'

const AdminSideMenu = () => {

  // url정보 받아올 hook
  const url = useLocation();



  return (
    <div className={styles.container}>
      {
        url.pathname.startsWith('/user')
        ?
          <div className={styles.menu_category}>
            <p>
              <span>
                <i className="bi bi-bag-fill"></i>
              </span>
              마이페이지
            </p>
            <ul className={styles.sideMenu}>
              <li className={styles.active}>장바구니</li>
              <li>구매이력</li>
              <li>내가 쓴 글</li>
            </ul>
          </div>
        :
        <>
          <div className={styles.menu_category}>
            <p>
              <span>
                <i className="bi bi-bag-fill"></i>
              </span>
              상품관리
            </p>
            <ul className={styles.sideMenu}>
              <li className={styles.active}>카테고리관리</li>
              <li>상품등록</li>
              <li>상품관리</li>
            </ul>
          </div>
          <div className={styles.menu_category}>
            <p>
              <span>
                <i className="bi bi-person-lines-fill"></i>
              </span>
              고객관리
            </p>
            <ul className={styles.sideMenu}>
              <li>고객정보조회</li>
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
            <ul className={styles.sideMenu}>
              <li>월별매출관리</li>
              <li>주간매출관리</li>
              <li>년간매출관리</li>
            </ul>
          </div>
        </>
      }
    </div>
  )
}

export default AdminSideMenu