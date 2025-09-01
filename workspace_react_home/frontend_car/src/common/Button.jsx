import React from 'react'
import styles from './Button.module.css'

// 공용 버튼을 만듦으로써 Button 컴포넌트를 button태그처럼 사용하면 된다.
// 버튼은 onclick이 필요하기 때문에 진짜 onclick을 실행시키는 함수를 onclick props로 전달해서 진짜 onclick에 전달해준다.
const Button = ({
  size='120px'
  , title='버튼'
  , color='blue'
  , padding='5px 12px'
  , fontSize='0.8rem'
  , onClick
  , ...props
}) => {
  return (
    <button
     type='button'
     // class를 두 개 한 번에 적용시키기 위한 문법이다.
     // 객체의 키 값에 변수를 주고 싶으면 []를 쓴다.
     // props로 disabled를 넘기지 않으면 undefined(falsy)가 나오는 원리를 이용해 단락평가를 한다.
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