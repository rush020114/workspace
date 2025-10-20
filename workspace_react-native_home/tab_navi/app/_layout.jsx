import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Stack } from 'expo-router'

// 최상위 레이아웃은 stack으로 세팅
// 아직 크게 신경 쓸 필요 없음.
const HomeLayout = () => {
  return (
    <Stack 
      screenOptions={{
        headerShown: false
      }}
    />
  )
}

export default HomeLayout

const styles = StyleSheet.create({})