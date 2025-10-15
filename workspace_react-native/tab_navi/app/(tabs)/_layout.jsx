import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Tabs } from 'expo-router'
import { FontAwesome, Ionicons } from '@expo/vector-icons'

// app/(tabs)/_layout.jsx
const TabLayout = () => {
  return (
    <Tabs
      screenOptions={{
        headerShown: false,
        tabBarInactiveTintColor: 'gray',
        tabBarActiveTintColor: 'tomato',
      }}
    >
      <Tabs.Screen 
        name='index' // 해당 탭에 연결될 jsx 파일명
        options={{ // 탭 디자인
          title: 'Home', // 탭에 보여지는 글자
          tabBarIcon: () => <FontAwesome name="home" size={24} color="tomato" />  
        }}
      />
      <Tabs.Screen 
        name='myPage' // 해당 탭에 연결될 jsx 파일명
        options={{
          title: '내 정보',
          tabBarIcon: () => <FontAwesome name='user' size={24} color="tomato" />
        }}
      />
      <Tabs.Screen 
        name='settings' // 해당 탭에 연결될 jsx 파일명
        options={{
          title: '설정',
          tabBarIcon: () => <Ionicons name="settings-sharp" size={24} color="tomato" />
        }}
      />
    </Tabs>
  )
}

export default TabLayout

const styles = StyleSheet.create({})