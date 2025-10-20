import { StyleSheet, Text, TextInput, View } from 'react-native'
import React, { useState } from 'react'

const Input = ({
  label=''
  , isPw=false
}) => {

  // input 태그의 focus를 저장하는 변수
  const [isFocus, setIsFocus] = useState(false);
  return (
    <View>
      {/* input 태그와 함께 쓰일 제목 문구는 쓰일 때도 있고 안 쓰일 때도 있으므로 단락 평가로 작성 */}
      {
        label
        &&
        <Text
          style={styles.label}
        >{label}</Text>
      }
      <TextInput 
        // input태그도 focus여부를 간접적으로 나타내 hover를 표현할 수 있다.
        style={[styles.input, isFocus ? styles.focused : null]}
        // focus 상태일 때 실행함수
        onFocus={() => setIsFocus(true)}
        // focus를 잃을 때 실행함수
        onBlur={() => setIsFocus(false)}
        // 비밀번호 여부
        secureTextEntry={isPw}
      />
    </View>
  )
}

export default Input

const styles = StyleSheet.create({
  input:  {
    borderColor: 'gray',
    borderWidth: 1,
    height: 40,
    borderRadius: 8,
    paddingHorizontal: 10
  },
  label: {
    marginBottom: 5,
    fontSize: 16,
    color: '#333333'
  },
  focused: {
    borderColor: 'black'
  }
})