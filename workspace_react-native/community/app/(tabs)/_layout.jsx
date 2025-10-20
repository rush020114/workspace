import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Tabs } from 'expo-router'

// (home), profile, settings 폴더를 tab 구조로 설정하는 파일
const TabLayout = () => {
  return (
    <Tabs
      screenOptions={{
        headerShown: false
      }}
    >
      <Tabs.Screen 
        name='(home)' // 첫번째 탭을 터치하면 (home)/index.jsx 파일이 실행
        options={{
          title: 'Home'
        }}
      />
      <Tabs.Screen 
        name='profile' // 두번째 탭을 터치하면 profile/index.jsx 파일이 실행
        options={{
          title: 'Profile'
        }}
      />
      <Tabs.Screen 
        name='settings' // 세번째 탭을 터치하면 settings/index.jsx 파일이 실행
        options={{
          title: 'Settings'
        }}
      />
    </Tabs>
  )
}

export default TabLayout

const styles = StyleSheet.create({})