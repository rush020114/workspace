import React from 'react'
import styles from './Input.module.css'

const Input = ({
  type='text'
  , size='300px'
  , ...props
}) => {
  return (
    <input
      type={type}
      style={{width: size}}
      className={styles.input}
      {...props}
    />
  )
}

export default Input