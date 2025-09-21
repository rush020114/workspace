import { Image, StyleSheet, Text, View } from 'react-native'
import React from 'react'
// 이미지는 경로를 지정해 import해준다. from앞에는 사용할 이름을 쓴다.
import del_img from '../assets/icons/delete.png'
import edit_img from '../assets/icons/edit.png'

// 통상적으로 app도 필요한 것들을 comoponent로 구성해 사용한다.
const Task = () => {
  return (
    <View style={styles.task_back}>
      <Text>할 일 내용</Text>
      <View style={styles.icon_view}>
        {/* 이미지 사용 방법은 react native에서 확안한다. 그 방법 중 선택한 것이다. */}
        <Image 
          source={edit_img}
        />
        <Image 
          source={del_img}
        />
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