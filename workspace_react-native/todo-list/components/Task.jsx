import { Alert, Image, Pressable, StyleSheet, Text, TextInput, View } from 'react-native'
import React, { useEffect, useState } from 'react'
// 이미지 import
// @ -> 최상위 경로에서부터 찾아가겠다.
import del_img from '@/assets/icon/delete.png'
import edit_img from '@/assets/icon/edit.png'
import axios from 'axios'
import { SERVER_URL } from '../constants/appConst'

/*
앱에서 alert 또는 comfirm을 사용하는 방법
Alert.alert('제목', '내용', 버튼정보)

ex)
Alert.alert(
  'Confirm',
  '정말 삭제할까요?',
  [
    {
      text: ,
      style: 'default',
      onPress: () => {}
    }, 
    {}
  ]
);
*/

// props로 전달되는 데이터를 state 변수의 초기값으로 바로 세팅하는 것은 지양!
const Task = ({todo, setReload}) => {

  // 수정 상태 값을 저장할 state 변수
  const [isUpdating, setIsUpdating] = useState();

  // 수정 내용을 저장할 state 변수
  const [updateTitle, setUpdateTitle] = useState('');

  // 목록 조회 useEffect
  useEffect(() => {
    setUpdateTitle(todo.todoTitle);
  }, []);

  console.log(updateTitle)

  // 할 일 수정 함수
  const updateTodo = () => {
    axios.put(`${SERVER_URL}/todo/${todo.todoNum}`, {todoTitle: updateTitle})
    .then(res => {
      alert(res.data);
      setReload(prev => prev + 1);
    })
    .catch(e => console.log(e));
  };
  
  // 삭제 버튼 터치 함수
  const deleteTodo = () => {
    Alert.alert(
      '확인',
      '정말 삭제할까요?',
      [
        {
          text: '삭제',
          style: 'default',
          onPress: () => confirmDelete()
        },
        {
          text: '취소',
          style: 'cancel',
          // 버튼을 누를 시 아무것도 실행시키지 않을 거면 onPress를 적지 않는다.
        },
      ]
    );
  };
  
  // 삭제 함수
  const confirmDelete = () => {
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
      {
        isUpdating
        ?
        <TextInput 
          style={styles.input}
          value={updateTitle}
          onBlur={() => setIsUpdating(false)}
          autoFocus={true} // input태그에 자동 포커스
          onChangeText={text => setUpdateTitle(text)}
          onSubmitEditing={() => updateTodo()}
        />
        :
        <Text style={styles.todo}>{todo.todoTitle}</Text>
      }
      <View style={styles.todo_view}>
        <Pressable
          onPress={() => setIsUpdating(true)}
        >
          <Image 
            source={edit_img}
            style={styles.img}
          />
        </Pressable>
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
  },

  input: {
    width: '70%',
    borderWidth: 1,
    borderColor: 'black',
    borderStyle: 'solid',
    backgroundColor: 'white'
  }
})