import React from 'react'
import styles from './Modal.module.css'

// props에 전달된 값에 어떤 값을 할당해놓으면 default값이 된다. 
// props로 전달되면 defualt 값이 변형된다.

// Modal 컴포넌트
// size => 모달의 크기 지정
// title => 모달의 제목 지정
// children(이름이 정해져 있는 값) => 모달의 내용부
const Modal = ({
  size = '500px', 
  title='', 
  isOpen=false, 
  onClose, 
  children
}) => {

  // component는 리턴을 그리기 때문에 return이 null이 되면 화면을 그리지 않는다.
  // isOpen이 false면 모달을 닫는다.
  if(!isOpen) return null;

  return (
    <div className={styles.modal_overlay}>
      <div
       className={styles.modal_content}
       style={{width: size}}
      >
        <div className={styles.modal_title}>
          <button
           type='button'
           className={styles.close_btn}
           onClick={onClose}
          >
            <i className="bi bi-x"></i>
          </button>
          <p>{title}</p>
        </div>
        <div className={styles.content_div}>
          {children}
        </div>
      </div>
    </div>
  );
};

export default Modal