import { StyleSheet, Text, TextInput, View } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import Task from '../components/Task'

const HomeScreen = () => {
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
        <Task />
        <Task />
        <Task />
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
    gap: 10
  }
})