import React from 'react'
import styles from './Button.module.css'

const Button = ({
  title='버튼'
  , size='80px'
  , color='blue'
  , padding='4px 12px'
  , fontSize='0.8rem'
  , onClick
  , ...props
}) => {
  return (
    <button
     type='button'
     // 객체의 key값에 변수를 쓰고 싶을 때 []를 쓴다.
     // disabled를 넘기지 않으면 props.disabled는 undefined(falsy)가 나온다.
     className={
      `${styles.btn} 
       ${styles[color]} 
       ${props.disabled && styles.disabled}`
     }
     style={{
      width: size
      , padding: padding
      , fontSize: fontSize
     }}
     onClick={onClick}
     {...props}
    >{title}</button>
  )
}

export default Button