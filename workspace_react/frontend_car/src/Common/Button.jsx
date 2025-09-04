import React from 'react'
import styles from './Button.module.css'

const Button = ({
  title='등록'
  , size='150px'
  , color='gray'
  , ...props
}) => {
  return (
    <button
      type='button'
      style={{width: size}}
      className={`${styles.button} ${styles[color]} ${props.disabled && styles.disable}`}
      {...props}
    >{title}</button>
  )
}

export default Button