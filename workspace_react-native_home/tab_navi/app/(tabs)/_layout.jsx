import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Tabs } from 'expo-router'
import { FontAwesome, Ionicons } from '@expo/vector-icons'

// ()로 싸여 있는 폴더는 파일 기반 경로 이동에서 폴더의 이름을 읽지 않는다.
const TabLayout = () => {
  return (
    // 탬 기반 페이지 이동
    // 레이아웃 자동 형성
    <Tabs
      screenOptions={{
        headerShown: false,
        // 활성화 페이지 디자인
        tabBarInactiveTintColor: 'gray',
        tabBarActiveTintColor: 'tomato'
      }}
    >
      <Tabs.Screen 
        name='index' // 해당 탭에 연결될 jsx파일명
        // tab에 표현될 레이아웃 디자인
        options={{
          title: 'Home',
          // reactnative는 아이콘이 많이 쓰이기 때문에 
          // 라이브러리 설치 시 자체적으로 지원
          tabBarIcon: () => <FontAwesome name='home' size={24} color="tomato" />
        }}
      />
      <Tabs.Screen 
        name='myPage'
        options={{
          title: '내 정보',
          // reactnative는 아이콘이 많이 쓰이기 때문에 
          // 라이브러리 설치 시 자체적으로 지원
          tabBarIcon: () => <FontAwesome name='user' size={24} color="tomato" />
        }}
      />
      <Tabs.Screen 
        name='settings'
        options={{
          title: '설정',
          // reactnative는 아이콘이 많이 쓰이기 때문에 
          // 라이브러리 설치 시 자체적으로 지원
          tabBarIcon: () => <Ionicons name='settings-sharp' size={24} color="tomato" />
        }}
      />
    </Tabs>
  )
}

export default TabLayout

const styles = StyleSheet.create({})