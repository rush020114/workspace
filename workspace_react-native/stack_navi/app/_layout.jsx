import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Stack } from 'expo-router'

// 같은 폴더 내의 페이지 구조를 설정하는 파일
const HomeLayout = () => {
  return (
    // 스택 구조로 만들겠다. 정의
    <Stack 
      screenOptions={{
        headerShown: false
      }}
    />
  )
}

export default HomeLayout

const styles = StyleSheet.create({})