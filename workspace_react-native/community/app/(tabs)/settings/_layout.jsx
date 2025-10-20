import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Stack } from 'expo-router'

// app/(tabs)/settings/_layout.jsx
// settings 폴더 안의 jsx 파일의 구조를 설정
const SettingsLayout = () => {
  return (
    <Stack 
      screenOptions={{
        headerShown: false
      }}
    />
  )
}

export default SettingsLayout

const styles = StyleSheet.create({})