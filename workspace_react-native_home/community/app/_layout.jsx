import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Stack } from 'expo-router'

// 앱 전체를 stack구조로 만들겠다를 정의
const RootLayout = () => {
  return (
    <Stack 
      screenOptions={{
        headerShown: false
      }}
    />
  )
}

export default RootLayout

const styles = StyleSheet.create({})