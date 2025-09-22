import { Image, StyleSheet, Text, View } from 'react-native'
import React from 'react'
// 이미지 import
// @ -> 최상위 경로에서부터 찾아가겠다.
import del_img from '@/assets/icon/delete.png'
import edit_img from '@/assets/icon/edit.png'

const Task = ({todo}) => {
  return (
    <View style={styles.task_back}>
      <Text style={styles.todo}>{todo.todoTitle}</Text>
      <View style={styles.todo_view}>
        <Image 
          source={edit_img}
          style={styles.img}
        />
        <Image
          source={del_img}
          style={styles.img}
        />
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