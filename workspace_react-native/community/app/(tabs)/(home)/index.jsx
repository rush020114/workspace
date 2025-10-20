import { Keyboard, StyleSheet, Text, TouchableWithoutFeedback, View } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import Button from '../../../components/common/Button'
import { useRouter } from 'expo-router'
import Input from '../../../components/common/Input'

// app/(tabs)/(home)/index.jsx
// sns 목록 페이지
const HomeScreen = () => {
  const router = useRouter();
  return (
    <TouchableWithoutFeedback
      onPress={() => Keyboard.dismiss()}
    >
      <SafeAreaView 
        style={styles.container}
      >
        <Text>HomeScreen</Text>
        <Button 
          title='sns 상세페이지로 이동' 
          size='normal' 
          onPress={() => router.push('/detail')}
        />
        <Input 
          label='아이디'
        />
      </SafeAreaView>
    </TouchableWithoutFeedback>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  container: {
    flex: 1
    , backgroundColor: 'white'
  }
})