import React from 'react'
import styles from './AdminSideMenu.module.css'
import { NavLink, useLocation } from 'react-router-dom'

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
            <ul className={styles.sidemenu}>
              <li className={styles.menu_li}>
                <NavLink
                  to={'/user/cart-list'}
                  className={({isActive}) => isActive ? styles.active : null}
                >장바구니</NavLink>
              </li>
              <li className={styles.menu_li}>
                <NavLink
                  to={'/user/buy-list'}
                  className={({isActive}) => isActive ? styles.active : null}
                >구매이력</NavLink>
              </li>
              <li className={styles.menu_li}>내 정보</li>
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
            <ul className={styles.sidemenu}>
              <li className={styles.active}>카테고리관리</li>
              <li className={styles.menu_li}>
                <NavLink
                  to={'/admin/reg-clothing'}
                  className={({isActive}) => isActive ? styles.active : null}
                >상품등록</NavLink>
              </li>
              <li className={styles.menu_li}>상품관리</li>
            </ul>
          </div>
          <div className={styles.menu_category}>
            <p>
              <span>
                <i className="bi bi-person-lines-fill"></i>
              </span>
              고객관리
            </p>
            <ul className={styles.sidemenu}>
              <li className={styles.menu_li}>고객정보조회</li>
              <li className={styles.menu_li}>고객정보변경</li>
              <li className={styles.menu_li}>게시판관리</li>
            </ul>
          </div>
          <div className={styles.menu_category}>
            <p>
              <span>
                <i className="bi bi-clipboard-data-fill"></i>
              </span>
              매출관리
            </p>
            <ul className={styles.sidemenu}>
              <li className={styles.menu_li}>
                <NavLink
                  to={'/admin/buy-list'}
                  className={({isActive}) => isActive ? styles.active : null}
                >구매정보조회</NavLink>
              </li>
              <li className={styles.menu_li}>주간매출관리</li>
              <li className={styles.menu_li}>년간매출관리</li>
            </ul>
          </div>
        </>
      }
    </div>
  )
}

export default AdminSideMenu