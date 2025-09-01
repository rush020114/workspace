import React from 'react'
import styles from './Select.module.css'

const Select = ({children, ...props}) => {
  return (
    <select
      {...props}
    >{children}</select>
  )
}

export default Select