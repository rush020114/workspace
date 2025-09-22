import { FlatList, StyleSheet, Text, TextInput, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import Task from '../components/Task'
import axios from 'axios'

const HomeScreen = () => {

  // 할 일 목록을 저장할 state 변수
  const [todoList, setTodoList] = useState([]);

  // 할 일 목록을 조회할 useEffect
  useEffect(() => {
    axios.get('http://192.168.204.69:8080/todos')
    .then(res => setTodoList(res.data))
    .catch(e => console.log(e));
  }, []);

  return (
    <SafeAreaView style={styles.container}>
      <View>
        <Text style={styles.title}>To Do List</Text>
      </View>
      <View style={styles.input_view}>
        <TextInput 
          placeholder='+Add a Task'
          style={styles.input}
        />
      </View>
      <View style={styles.list_view}>
        {/* map함수와 같은 역할 코드 대신 props로 구성 */}
        <FlatList 
          // 반복 돌릴 데이터
          data={todoList}
          // 반복돌릴 하나하나의 데이터 그림을 그릴 것을 함수의 리턴문에 작성
          renderItem={({item}) => <Task todo={item} />}
          // map의 key값 채우는 것과 같은 역할
          keyExtractor={todo => todo.todoNum}
        />
      </View>
    </SafeAreaView>
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