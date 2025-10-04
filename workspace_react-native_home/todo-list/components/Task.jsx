import { Alert, Image, Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'
// 이미지는 경로를 지정해 import해준다. from앞에는 사용할 이름을 쓴다.
import del_img from '../assets/icons/delete.png'
import edit_img from '../assets/icons/edit.png'
import axios from 'axios'
import { SERVER_URL } from '../constants/appConst'

// 통상적으로 app도 필요한 것들을 comoponent로 구성해 사용한다.
// 필요한 데이터를 props로 전달해 사용한다.
const Task = ({todo, setReload}) => {
  
  // 할 일 삭제 함수
  const deleteTodo = () => {

    // 삭제 확인 용 alert
    Alert.alert()

    axios.delete(`${SERVER_URL}/todos/${todo.todoNum}`)
    .then(res => {
      alert(res.data);
      setReload(prev => prev + 1)
    })
    .catch(e => console.log(e));
  };

  return (
    <View style={styles.task_back}>
      <Text>{todo.todoTitle}</Text>
      <View style={styles.icon_view}>
        {/* 이미지 사용 방법은 react native에서 확안한다. 그 방법 중 선택한 것이다. */}
        <Image 
          source={edit_img}
        />
        <Pressable
          onPress={() => deleteTodo()}
        >
          <Image 
            source={del_img}
          />
        </Pressable>
      </View>
    </View>
  )
}

export default Task

const styles = StyleSheet.create({
  task_back: {
    flexDirection: 'row',
    alignItems: 'center',
    backgroundColor: '#eeeeee',
    padding: 15,
    gap: 5,
    borderRadius: 5
  },

  icon_view: {
    flexDirection: 'row',
    marginLeft: 'auto',
    gap: 10
  }
})