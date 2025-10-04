import { FlatList, Keyboard, StyleSheet, Text, TextInput, TouchableWithoutFeedback, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import Task from '../components/Task'
import axios from 'axios'
import { SERVER_URL } from '../constants/appConst'

const HomeScreen = () => {

  // 라렌더링해줄 state 변수
  const [reload, setReload] = useState(0);

  // 할 일 목록을 저장할 state 변수
  const [todoList, setTodoList] = useState([]);

  // 할 일을 등록할 state 변수
  const [todoTitle, setTodoTitle] = useState('');

  // 할 일 목록을 조회할 useEffect
  useEffect(() => {
    axios.get(`${SERVER_URL}/todos`)
    .then(res => setTodoList(res.data))
    .catch(e => console.log(e));
  }, [reload]);

  // 할 일 등록
  const regTodo = () => {
    axios.post(`${SERVER_URL}/todos`, {todoTitle})
    .then(res => {
      alert(res.data);
      setTodoTitle('');
      setReload(reload + 1)
    })
    .catch(e => console.log(e));
  };


  console.log(todoList)

  return (
    // 화면 전체를 영역으로 잡고 터치할 시 진동 등의 피드백은 없지만 
    // 터치하여 무슨 이벤트를 발생시킬 수 있다.
    // onPress로 키보드를 벗어난 곳 터치 시 키보드를 사라지게 할 수 있다.
    <TouchableWithoutFeedback
      onPress={Keyboard.dismiss}
    >
      <SafeAreaView style={styles.container}>
        <View>
          <Text style={styles.title}>To Do List</Text>
        </View>
        <View style={styles.input_view}>
          <TextInput 
            placeholder='+Add a Task'
            style={styles.input}
            value={todoTitle}
            onChangeText={e => setTodoTitle(e)}
            // 키보드 자판기의 확인 등의 역할을 하는 키 터치 시 발생
            onSubmitEditing={() => regTodo()}
            // keyboard자판이 focus를 잃었을 때 실행
            onBlur={() => setTodoTitle('')}
          />
        </View>
        <View style={styles.list_view}>
          {/* map함수와 같은 역할 코드 대신 props로 구성 */}
          <FlatList 
            // 반복 돌릴 데이터
            data={todoList}
            // 반복돌릴 하나하나의 데이터 그림을 그릴 것을 함수의 리턴문에 작성
            renderItem={({item}) => <Task 
              todo={item} 
              setReload={setReload}
            />}
            // map의 key값 채우는 것과 같은 역할
            keyExtractor={todo => todo.todoNum}
          />
        </View>
      </SafeAreaView>
    </TouchableWithoutFeedback>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  container: {
    flex: 1 // 화면을 꽉 채우는 방법(부모 태그의 비율에 맞게 화면을 채움)
    , padding: 20
  },

  title: {
    fontSize: 35
    , fontWeight: 'bold'
  },

  input_view: {
    marginVertical: 20
  },

  input: {
    borderWidth: 1,
    borderColor: '#cccccc',
    borderStyle: 'solid'
  },

  list_view: {
    backgroundColor: '#777777',
    padding: 10,
    borderRadius: 5,
    gap: 10,
    flexDirection: 'row'
  }
})