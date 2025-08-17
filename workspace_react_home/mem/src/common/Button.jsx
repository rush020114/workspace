import React from 'react'
import styles from './Button.module.css'

const Button = ({
  size='80px'
  , content='버튼'
  , color='green'
  , onClick
}) => {
  return (
    <button
     type='button'
     className={`${styles.btn} ${styles[color]}`}
     style={{width: size}}
     onClick={e => onClick}
    >
      {content}
    </button>
  )
}

export default Button