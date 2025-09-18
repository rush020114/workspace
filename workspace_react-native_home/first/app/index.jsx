import { useState } from 'react';
import { Pressable, StyleSheet, Text, TextInput } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';

// 컴포넌트 생성 시 파일명과 컴포넌트명이 다를 수 있다.
const HomeScreen = () => {

  // input 데이터를 저장할 state 변수
  const [memData, setMemData] = useState({
    name: ''
    , age: ''
    , addr: ''
  });

  // input 데이터를 세팅할 함수
  // key값을 매개변수로 전달할 수 있기에 name속성이 필요없다.
  const handleMemData = (value, key) => {
    setMemData({
      ...memData, 
      [key]: value
    });
  };

  return (
    // status영역을 계산해 겹치지 않게 해준다.
    // component를 렌더링할 때 오른편의 글자를 잘 봐야 한다.
    // 컴포넌트의 css default는 flex이고 방향은 column이다.
    <SafeAreaView
      style={{gap: 10}}
    >
      {/* Text안에 글자를 적어야 화면에 반영된다. */}
      <Text>Home</Text>
      {/* 버튼은 pressable(앱은 누르는 것이 클릭)을 사용한다. */}
      {/* 속성은 onPress가 onClick과 같은 역할이다. */}
      <Pressable
        onPress={() => alert(1)}
      >
        <Text>버 튼</Text>
      </Pressable>
      {/* input과 같은 컴포넌트 */}
      <TextInput 
        style={styles.input}
        // app에선 onChange대신 onChangeText를 쓴다.
        // 이 속성의 매개변수값은 e.target.value와 같다.
        // value속성이 없이도 값이 입력된다.
        onChangeText={value => handleMemData(value, 'name')}
      />
      <TextInput 
        style={styles.input}
        onChangeText={value => handleMemData(value, 'age')}
      />
      <TextInput 
        style={styles.input}
        onChangeText={value => handleMemData(value, 'addr')}
      />
      <Pressable
        style={styles.button}
        onPress={() => alert(`이름: ${memData.name} 나이: ${memData.age} 주소: ${memData.addr}`)}
      >
        <Text>버 튼</Text>
      </Pressable>
    </SafeAreaView>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  // css는 이 곳에서 준다.
  // 클래스명을 이 곳에 지어 컴포넌트에 적용해준다.
  input: {
    borderBottomColor: 'black',
    // app의 css는 px와 같은 단위를 쓰지 않는다.
    borderBottomWidth: 1,
    borderStyle: 'solid',
    width: 100
  },

  button: {
    borderColor: 'black',
    borderWidth: 1,
    borderStyle: 'solid',
    width: 100
  }
})