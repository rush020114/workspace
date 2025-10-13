import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { useLocalSearchParams } from 'expo-router'
import { SafeAreaView } from 'react-native-safe-area-context';

const DetailScreen = () => {
  // 전달되는 데이터 받기
  const {id, age} = useLocalSearchParams();

  return (
    <SafeAreaView>
      <Text>DetailScreen</Text>
      <Text>{id} / {age}</Text>
    </SafeAreaView>
  )
}

export default DetailScreen

const styles = StyleSheet.create({})