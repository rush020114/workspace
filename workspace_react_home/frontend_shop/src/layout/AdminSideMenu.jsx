import React from 'react'
import styles from './AdminSideMenu.module.css'
import { NavLink, useLocation } from 'react-router-dom'

const AdminSideMenu = () => {

  const url = useLocation();

  console.log(url.pathname.startsWith('/user'))

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
          <ul className={styles.side_menu}>
            {/* 
              NavLink컴포넌트는 현재 클릭한 페이지에 디자인을 줄 때 활용된다. 
              Link컴포넌트의 확장판으로 to속성은 경로를 지정
              className속성은 다른 클래스와 달리 함수가 중괄호 안으로 들어간다.
              그 함수의 매개변수에는 현재 url과 지정한 경로가 같을 때 true 아닐 때 false를 반환하는
              객체의 value가 들어가 있다. 그 key는 isActive로 구조분해할당을 사용하면 편하다. 
            */}
            <li className={styles.menu_li}>
              <NavLink
                to={'/user/cart-list'}
                // 단락평가 해석 상 false가 &&앞에 오면 false를 반환하기 때문에 클래스명으로는 적당하지 않아 삼항연산자를 사용한다.
                className={({isActive}) => isActive ? styles.active : null}
              >장바구니</NavLink>
            </li>
            <li className={styles.menu_li}>
              <NavLink
                to={'/user/buy-list'}
                className={({isActive}) => isActive ? styles.active : null}
              >구매이력</NavLink>
            </li>
            <li className={styles.menu_li}>내 정보 관리</li>
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
            <ul className={styles.side_menu}>
              <li className={styles.menu_li}>
                <NavLink
                  to={'/admin/reg-book'}
                  className={({isActive}) => isActive ? styles.active : null}
                >카테고리관리</NavLink>
              </li>
              <li className={styles.menu_li}>도서등록</li>
              <li className={styles.menu_li}>도서관리</li>
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
              <li className={styles.menu_li}>고객정보관리</li>
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
            <ul className={styles.side_menu}>
              <li className={styles.menu_li}>
                <NavLink
                  to={'/admin/buy-list'}
                  className={({isActive}) => isActive ? styles.active : null}
                >구매이력조회</NavLink>
              </li>
              <li className={styles.menu_li}>주간매출관리</li>
              <li className={styles.menu_li}>연간매출관리</li>
            </ul>
          </div>
        </>
      }
    </div>
  )
}

export default AdminSideMenu