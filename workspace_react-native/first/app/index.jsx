import { useState } from 'react';
import { Pressable, StyleSheet, Text, TextInput, View } from 'react-native';
import { SafeAreaView } from 'react-native-safe-area-context';

const HomeScreen = () => {

  // input 태그에 입력한 글자를 저장할 state 변수
  const [data, setData] = useState('');

  // 이름, 나이, 주소값을 저장할 state 변수
  const [memberData, setMemeberData] = useState({
    name: ''
    , age: ''
    , addr: ''
  });

  const handleMemberData = (value, key) => {
    setMemeberData({
      ...memberData
      , [key] : value
    })
  }

  return (
    <SafeAreaView style={{gap: 10}}>
      <Text
        // 디자인 적용 방법
        style={styles.my_text}
      >index</Text>
      <Pressable 
        onPress={() => alert(1)}
        style={styles.my_btn}
      >
        <Text>버튼</Text>
      </Pressable>
      <View
        style={styles.view}
      >
        <TextInput
          style={styles.input}
          value={data}
          // onChangeText 이벤트의 매개변수는 입력한 글자를 의미
          onChangeText={str => setData(str)}
        />
        <Pressable
          style={styles.pre}
          onPress={() => alert(data)}
        >
          <Text
            style={styles.btn}
          >클 릭</Text>
        </Pressable>
      </View>

      <View>
        <Text>이름</Text>
        <TextInput 
          onChangeText={value => handleMemberData(value, 'name')}
        />
        <Text>나이</Text>
        <TextInput 
          onChangeText={value => handleMemberData(value, 'age')}
        />
        <Text>주소</Text>
        <TextInput 
          onChangeText={value => handleMemberData(value, 'addr')}
        />
        <Pressable
          onPress={() => alert(
            `이름 : ${memberData.name}, 나이 : ${memberData.age}, 주소 : ${memberData.addr}`
          )}
        >
          <Text>버 튼</Text>
        </Pressable>
      </View>

    </SafeAreaView>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  my_text: {
    backgroundColor: 'red',
    // 앱 디자인에선 px과 같은 단위를 주지 않는다.
    padding: 10
  },

  my_btn: {
    backgroundColor: 'blue',
    padding: 10,
    borderWidth: 1,
    borderColor: 'black',
    borderStyle: 'solid'
  },
  
  input: {
    borderBottomWidth: 1,
    borderBottomColor: 'black',
    borderStyle: 'solid',
    width: 100,
  },
  
  pre: {
    borderWidth: 3,
    borderColor: 'yellow',
    borderStyle: 'solid',
    backgroundColor: 'red',
    padding: 10,
    width: '50%'
  },
  
  btn: {
    borderWidth: 3,
    borderColor: 'skyblue',
    borderStyle: 'solid',
    backgroundColor: 'beige',
    textAlign: 'center'
  },

  view: {
    flexDirection: 'row',
    gap: 30
  }
})