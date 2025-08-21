import React from 'react'
import styles from './Input.module.css'

// props를 스프레드 연산자를 써서 사용하면 다른 정해진 인자와 공용으로 사용할 수 있게 된다.
// props의 매개변수는 하나의 인자밖에 전달받지 못한다. 그래서 중괄호 안에 모두 위치시켜야 한다.
// 스프레드 연산자 없이 props를 다른 인자들과 함께 사용하면 props는 객체에 객체가 덮이게 된다(오류).
// ...props는 key 값이 아니지만 나머지를 받을 수 있는 문법이었고 그 나머지는 props로 객체 형태로 받는데 
// 스프레드 연산자를 씀으로써 문법적 오류가 없게끔 된다.
// 현재의 props 형태는 기본 인자를 제외한 나머지 인자의 객체 형태이므로
// input 태그에 스프레드 연산자로 뿌려줄 수 있다(중괄호는 객체로 감싸는 문법이 아닌 변수를 사용하기 위한 문법).
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