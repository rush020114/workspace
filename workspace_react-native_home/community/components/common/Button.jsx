import { Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'

const Button = ({
  title='버튼'
  , size='large'
  , onPress
  , ...props
}) => {
  return (
    <Pressable
      // pressable컴포넌트로 터치 시 적용할 디자인을 구현할 수 있다.(hover)
      // 매개변수의 key pressed로 터치 유무 판단 가능
      // 여러 클래스 동시 사용은 배열로 진행한다.
      style={({pressed}) => [
        styles.btnContainer
        , styles[size]
        , pressed ? styles.pressed : null
      ]}
      onPress={() => onPress()}
      {...props}
    >
      <Text>
        {title}
      </Text>
    </Pressable>
  )
}

export default Button

const styles = StyleSheet.create({
  btnContainer: {
    backgroundColor: 'orange',
    borderRadius: 8,
    justifyContent: 'center',
    alignItems: 'center'
  },
  large: {
    width: '100%',
    height: 35
  },
  normal: {
    width: '70%'
    , height: 30
  },
  pressed: {
    opacity: 0.8
  }
})