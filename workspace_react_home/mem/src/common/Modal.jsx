import React from 'react'
import styles from './Modal.module.css'

const Modal = ({
  title=''
  , size='300px'
  , color='green'
  , children
  , isOpen=false
  , onClose
}) => {
  if(!isOpen) return null;

  return (
    <div className={styles.modal_overlay}>
      <div className={styles.modal_content}>
        <div
         className={styles.modal_title}
         style={{width: size}}
        >
          <h2
           className={styles[color]}
          >{title}</h2>
          <button
           type='button'
           onClick={onClose}
          >
            <i className="bi bi-x"></i>
          </button>
        </div>
        <div className={styles.content_div}>
          {children}
        </div>
      </div>
    </div>
  )
}

export default Modal