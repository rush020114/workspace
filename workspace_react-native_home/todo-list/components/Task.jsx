import { Alert, Image, Pressable, StyleSheet, Text, TextInput, View } from 'react-native'
import React, { useEffect, useState } from 'react'
// 이미지는 경로를 지정해 import해준다. from앞에는 사용할 이름을 쓴다.
import del_img from '../assets/icons/delete.png'
import edit_img from '../assets/icons/edit.png'
import axios from 'axios'
import { SERVER_URL } from '../constants/appConst'

// 통상적으로 app도 필요한 것들을 comoponent로 구성해 사용한다.
// 필요한 데이터를 props로 전달해 사용한다.
const Task = ({todo, setReload}) => {

  // 수정 상태 값을 저장할 state 변수
  const [isUpdating, setIsUpdating] = useState(false);

  // 수정 내용을 저장할 state 변수
  const [updateTitle, setUpdateTitle] = useState();

  // 목록 조회 useEffect
  useEffect(() => {
    setUpdateTitle(todo.todoTitle);
  }, []);

  // 할 일 수정 함수
  const updateTodo = () => {
    axios.put(`${SERVER_URL}/todos/${todo.todoNum}`, {todoTitle: updateTitle})
    .then(res => {
      alert(res.data);
      setReload(prev => prev + 1);
    })
    .catch(e => console.log(e));
  };

  // 삭제 confirm 함수
  const confirmDelete = () => {
    // 삭제 확인 용 alert
    Alert.alert(
      '확인',
      '정말 삭제할까요?',
      [
        {
          text: '삭제',
          style: 'default',
          onPress: () => deleteTodo()
        },
        {
          text: '취소',
          style: 'cancel',
          // 버튼 클릭 시 아무것도 실행시키지 않을 거면 onPress를 적지 않는다.
        }
      ]
    );
  };
  
  // 할 일 삭제 함수
  const deleteTodo = () => {

    axios.delete(`${SERVER_URL}/todos/${todo.todoNum}`)
    .then(res => {
      alert(res.data);
      setReload(prev => prev + 1)
    })
    .catch(e => console.log(e));
  };

  return (
    <View style={styles.task_back}>
    {
      isUpdating
      ?
      <TextInput 
        style={styles.input}
        value={updateTitle}
        onBlur={() => setIsUpdating(false)}
        autoFocus={true} // input 태그에 자동 포커서
        onChangeText={text => setUpdateTitle(text)}
        onSubmitEditing={() => updateTodo()}
      />
      :
      <Text>{todo.todoTitle}</Text>
    }
      <View style={styles.icon_view}>
        {/* 이미지 사용 방법은 react native에서 확안한다. 그 방법 중 선택한 것이다. */}
        <Pressable
          onPress={() => setIsUpdating(true)}
        >
          <Image 
            source={edit_img}
          />
        </Pressable>
        <Pressable
          onPress={() => confirmDelete()}
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
  },

  input: {
    width: '70%',
    borderWidth: 1,
    borderColor: 'black',
    borderStyle: 'solid',
    backgroundColor: 'white'
  }
})