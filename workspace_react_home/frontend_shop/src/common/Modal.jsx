import React from 'react'
import styles from './Modal.module.css'

// props를 쓰면 공용으로 쓰는 컴포넌트에 내용과 디자인 요소들을 넘길 수 있다.
// 넘겨진 props를 받는 props에 값을 할당하면 기본값이 된다.
// 바로 닫지 않은 컴포넌트 안에 html 태그들을 넣으면 children이라는 값으로 받아올 수 있다. 
// modal을 열 수 있는 요소들은 보통 바깥에 있으므로 논리 값을 저장하는 state변수를 선언해 true값을 props로 isOpen에 전달한다.
// modal을 닫을 수 있는 x표시 같은 것은 modal 안에 있으므로 state변경 함수를 전달해 버튼 클릭 시 isOpen으로 전달되는 값을 false로 변경될 수 있게 설계한다.
const Modal = ({isOpen=false, size='500px', title, onClose, children}) => {

  // modal창의 특성상 modal은 열고 닫혀야 하므로 
  // return 안에 열고 닫을 수 있는 조건문을 넣어준다.
  if(!isOpen) return null;

  return (
    <div className={styles.modal_overlay}>
      <div
       className={styles.modal_content}
       style={{width:size}}
      >
        <div className={styles.modal_title}>
          <p>{title}</p>
          <span
           onClick={onClose}
           className={styles.close_btn}
          >
            <i className="bi bi-x"></i>
          </span>
        </div>
        <div className={styles.content_div}>
          {children}
        </div>
      </div>
    </div>
  )
}

export default Modal