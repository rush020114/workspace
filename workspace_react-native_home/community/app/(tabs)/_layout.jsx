import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Tabs } from 'expo-router'

const TabLayout = () => {
  return (
    <Tabs
      screenOptions={{
        headerShown: false
      }}
    >
      {/* 지금 경우의 name은 폴더 경로를 지정하는 거고, 그 폴더 안의 index.jsx가 자동으로 실행 */}
      <Tabs.Screen 
        name='(home)'
        options={{
          title: 'Home'
        }}
      />
      <Tabs.Screen 
        name='profile'
        options={{
          title: 'Profile'
        }}
      />
      <Tabs.Screen 
        name='settings'
        options={{
          title: 'Settings'
        }}
      />
    </Tabs>
  )
}

export default TabLayout

const styles = StyleSheet.create({})