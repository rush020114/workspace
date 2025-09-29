import { FlatList, StyleSheet, Text, TextInput, View } from 'react-native'
import { SafeAreaView } from 'react-native-safe-area-context'
import Task from '../components/Task'
import { useEffect, useState } from 'react'
import axios from 'axios'
import { TouchableWithoutFeedback } from 'react-native'
import { Keyboard } from 'react-native'

const HomeScreen = () => {

  // 등록 시 리렌더링해 줄 state 변수
  const [reload, setReload] = useState(0);

  // 조회한 할 일 목록 데이터를 저장할 state 변수
  const [todoList, setTodoList] = useState([]);

  // 입력한 제목 데이터를 저장할 state 변수
  const [todoTitle, setTodoTitle] = useState('');

  // 마운트되면 목록 조회
  useEffect(() => {
    // localhost를 인식하지 못함
    // pc의 ip주소를 통해 접근해야 한다.
    axios.get('http://192.168.30.79:8080/todo')
    .then(res => setTodoList(res.data))
    .catch(e => console.log(e));
  }, [reload]);

  // 할 일 등록 
  const regTodo = () => {
    axios.post('http://192.168.30.79:8080/todo', {todoTitle})
    .then(res => {if(res.status === 201){
      alert('등록 성공');
      setTodoTitle('');
      setReload(reload + 1);
    }})
    .catch(e => {
      // 오류 상태 코드
      const errorCode = e.status;
      if(errorCode === 400 || errorCode === 500){
        alert(`오류코드 : ${errorCode} \n 오류 메시지 : ${e.response.data}`);
      }
      else{
        console.log(e);
      }
    });
  };

  return (
    // touch만 가능(터치 시 진동 같은 피드백은 없음)
    // 전체 영역에 touch가 되게끔 컴포넌트 렌더링
    // 빈 화면 터치 시 키보드 숨김 기능을 구현할 때 사용
    // onPress props에 키보드 숨김 기능을 구현
    <TouchableWithoutFeedback
      onPress={Keyboard.dismiss}
    >
      <SafeAreaView style={styles.container}>
        <View>
          <Text style={styles.title}>To Do List</Text>
        </View>
        <View style={styles.input_view}>
          <TextInput 
            style={styles.input}
            placeholder='+ Add a Task'
            value={todoTitle}
            onChangeText={text => setTodoTitle(text)}
            // 키보드 자판기의 확인 등의 키 터치 시 발생
            onSubmitEditing={() => regTodo()}
            // 인풋 태그가 focus를 잃었을 때 실행
            onBlur={() => setTodoTitle('')}
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
    </TouchableWithoutFeedback>
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
  },

})