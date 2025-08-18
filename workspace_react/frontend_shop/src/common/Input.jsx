import React from 'react'
import styles from './Input.module.css'

const Input = ({
  size='120px'
  , type='text'
  , ...props
}) => {
  return (
    <input
     style={{width: size}}
     type={type}
     className={styles.input} 
     {...props} 
    />
  )
}

export default Input