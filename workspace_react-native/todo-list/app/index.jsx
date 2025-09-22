import { FlatList, StyleSheet, Text, TextInput, View } from 'react-native'
import { SafeAreaView } from 'react-native-safe-area-context'
import Task from '../components/Task'
import { useEffect, useState } from 'react'
import axios from 'axios'

const HomeScreen = () => {

  // 조회한 할 일 목록 데이터를 저장할 state 변수
  const [todoList, setTodoList] = useState([]);

  // 마운트되면 목록 조회
  useEffect(() => {
    axios.get('http://192.168.30.79:8080/todo')
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
          style={styles.input}
          placeholder='+ Add a Task'
        />
      </View>
      <View style={styles.list_view}>
        <FlatList
          // 전체 데이터
          data={todoList}
          // 데이터로 그림 그리기, 매개변수 : 데이터 하나하나
          // 매개변수가 객체이므로 key값을 지킬 것
          renderItem={({item}) => <Task todo={item} />}
          // map의 key={i} 내용과 동일
          keyExtractor={todo => todo.todoNum}
        />
      </View>
    </SafeAreaView>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  container : {
    flex: 1, // 최상위 태그의 높이를 폰 화면에 꽉 차게 변경
    padding: 20

    // paddingHorizontal: 10, 좌우 패딩
    // paddingVertical: 10    상하 패딩
  },

  input: {
    borderWidth: 1,
    borderColor: '#cccccc',
    borderStyle: 'solid'
  },

  title: {
    fontSize: 35,
    fontWeight: 'bold'
  },

  input_view: {
    marginVertical: 20
  },

  list_view: {
    padding: 10,
    backgroundColor: '#cccccc',
    gap: 10
  }
})