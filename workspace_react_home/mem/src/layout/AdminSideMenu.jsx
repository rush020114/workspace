import React, { useEffect } from 'react'
import styles from './AdminSideMenu.module.css'
import { NavLink, useLocation } from 'react-router-dom'

const AdminSideMenu = ({notiCnt,onResetCnt}) => {

  // url정보 받아올 hook
  const url = useLocation();

  // 배지를 띄울지 말지를 결정할 주소를 저장할 hook
  const location = useLocation();

  // 관리자 qna 페이지인지
  const isAdminQnA = location.pathname === '/admin/qna'

  // 이용자 qna 페이지인지
  const isUserQnA = location.pathname === '/user/info'

  // 이미 문의 목록이면 notiCnt 0으로 초기화
  useEffect(() => {
    if(isAdminQnA && isUserQnA && notiCnt > 0){
      onResetCnt();
    };
  }, [notiCnt, isAdminQnA, isUserQnA]);

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
              <li className={styles.menu_li}>
                <NavLink
                  to={'/user/info'}
                  className={({isActive}) => isActive ? styles.active : null}
                  onClick={() => onResetCnt()}
                  style={{position: 'relative'}}
                >내 정보
                {
                  notiCnt > 0 &&
                  (<span className='badge'>
                    {notiCnt > 99 ? '99+' : notiCnt}
                  </span>)
                }
                </NavLink>
              </li>
              <li className={styles.menu_li}>
                <NavLink
                  to={'/user/qna'}
                  className={({isActive}) => isActive ? styles.active : null}
                >문의</NavLink>
              </li>
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
              <li className={styles.menu_li}>고객정보</li>
              <li className={styles.menu_li}>
                {/* 배지 추가 */}
                <NavLink
                  to={'/admin/qna'}
                  className={({isActive}) => isActive ? styles.active : null}
                  onClick={onResetCnt}  // 클릭 시 초기화
                  style={{ position: 'relative' }}
                >
                  문의사항
                  {notiCnt > 0 && (
                    <span className='badge'>
                      {notiCnt > 99 ? '99+' : notiCnt}
                    </span>
                  )}
                </NavLink>
              </li>
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