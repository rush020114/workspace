import { Image, Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'
// 이미지 import
// @ -> 최상위 경로에서부터 찾아가겠다.
import del_img from '@/assets/icon/delete.png'
import edit_img from '@/assets/icon/edit.png'
import axios from 'axios'
import { SERVER_URL } from '../constants/appConst'

const Task = ({todo, setReload}) => {

  // 삭제 버튼 터치 함수
  const deleteTodo = () => {
    axios.delete(`${SERVER_URL}/todo/${todo.todoNum}`)
    .then(res => {
      alert(res.data);
      setReload(prev => prev + 1);
    })
    .catch(e => {
      if(e.status === 400 || e.status === 500){
        alert(`오류 코드 : ${e.status} \n 오류 내용 : ${e.response.data}`);
      }
      else{
        alert('알 수 없는 오류가 발생했습니다.');
        console.log(e);
      };
    });
  };

  return (
    <View style={styles.task_back}>
      <Text style={styles.todo}>{todo.todoTitle}</Text>
      <View style={styles.todo_view}>
        <Image 
          source={edit_img}
          style={styles.img}
        />
        {/* 터치 기능 구현 시 pressable 컴포넌트를 사용 */}
        <Pressable
          onPress={() => deleteTodo()}
        >
          <Image
            source={del_img}
            style={styles.img}
          />
        </Pressable>
      </View>
    </View>
  )
}

export default Task

const styles = StyleSheet.create({
  task_back: {
    backgroundColor: '#eeeeee',
    padding: 15,
    flexDirection: 'row',
    alignItems: 'center',
    gap: 5
  },

  todo: {
    fontSize: 20,
    verticalAlign: 'middle',
  },

  todo_view: {
    marginLeft: 'auto',
    flexDirection: 'row',
    gap: 10
  }
})