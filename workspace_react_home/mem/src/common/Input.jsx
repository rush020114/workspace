import React from 'react'
import styles from './Input.module.css'

const Input = ({
  type='text'
  , size='80px'
  , ...props
}) => {
  return (
    <input
     className={styles.input}
     type={type}
     style={{width: size}}
     {...props}
    ></input>
  )
}

export default Input