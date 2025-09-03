import React from 'react'
import styles from './Input.module.css'

const Input = ({
  size='120px'
  , type='text'
  , padding='5px'
  , fontSize='12px'
  , ...props
}) => {
  return (
    <input
     style={{
      width: size
      , padding: padding
      , fontSize: fontSize
     }}
     type={type}
     className={styles.input} 
     {...props} 
    />
  )
}

export default Input