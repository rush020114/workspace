import React from 'react'
import styles from './Button.module.css'

const Button = ({title='등록', ...props}) => {
  return (
    <button
      type='button'
      {...props}
    >{title}</button>
  )
}

export default Button