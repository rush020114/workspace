import { Keyboard, StyleSheet, Text, TouchableWithoutFeedback, View } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import axios from 'axios'
import { SERVER_URL } from '../../../constants/appConst'
import Button from '../../../components/common/Button'

const ProfileHomeScreen = () => {

  const test1 = () => {
    axios.get(`${SERVER_URL}`)
    .then(res => console.log(res.data))
    .catch(e => console.log(e));
  };

  // 일반 통신
  const test2 = () => {
    axios.get(`${SERVER_URL}/t1`)
    .then(res => console.log(res.data))
    .catch(e => console.log(e));
  }

  // urlParameter
  const test3 = () => {
    axios.get(`${SERVER_URL}/t2/3`)
    .then(res =>  console.log('통신 성공'))
    .catch(e => console.log(e));
  }

  // post 방식
  const test4 = () => {
    axios.post(`${SERVER_URL}/t3`, {
      stuName: 'kim'
      , stuAge: 20
    })
    .then(res => console.log('통신 성공'))
    .catch(e => console.log(e))
  }

  // query string
  const test5 = () => {
    axios.get(`${SERVER_URL}/t4`, {params: {
      stuName: 'lee'
      , stuAge: 20
    }})
    .then(res => console.log('통신 성공'))
    .catch(e => console.log(e))
  }

  return (
    <TouchableWithoutFeedback onPress={Keyboard.dismiss()}>
      <SafeAreaView
        style={styles.btnContainer}
      >
        <Button 
          title='버튼1'
          onPress={() => test1()}
        />
        <Button 
          title='버튼2'
          onPress={() => test2()}
        />
        <Button 
          title='버튼3'
          onPress={() => test3()}
        />
        <Button 
          title='버튼4'
          onPress={() => test4()}
        />
        <Button 
          title='버튼5'
          onPress={() => test5()}
        />
      </SafeAreaView>
    </TouchableWithoutFeedback>
  )
}

export default ProfileHomeScreen

const styles = StyleSheet.create({
  btnContainer: {
    width: '50%',
    gap: 10,
    marginHorizontal: 'auto'
  }
})
