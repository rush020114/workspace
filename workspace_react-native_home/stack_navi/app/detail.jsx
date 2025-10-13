import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { useLocalSearchParams } from 'expo-router'
import { SafeAreaView } from 'react-native-safe-area-context';

const detailScreen = () => {
  // 페이지 이동 시 params로 전달되는 데이터는
  // useLocalSearchParams로 받을 수 있다.(객체 형태)
  const {id, age} = useLocalSearchParams();
  return (
    <SafeAreaView>
      <Text>detailScreen</Text>
      <Text>{id} / {age}</Text>
    </SafeAreaView>
  )
}

export default detailScreen

const styles = StyleSheet.create({})