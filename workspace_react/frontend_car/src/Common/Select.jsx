import React from 'react'
import styles from './Select.module.css'

const Select = ({
  size='300px'
  , children
  , ...props
}) => {
  return (
    <select
      style={{width: size}}
      className={styles.select}
      {...props}
    >{children}</select>
  )
}

export default Select