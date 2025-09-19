import { StyleSheet, Text, TextInput, View } from 'react-native'
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
          style={styles.input}
          placeholder='+ Add a Task'
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