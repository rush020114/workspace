import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { Stack } from 'expo-router'

// 같은 폴더 내의 페이지 구조를 설정하는 파일
// 순수 설치가 아닌 expo 기반 프로젝트는 파일 기반 라우터 구조를 갖는다.
const HomeLayout = () => {
  return (
    // stack 구조를 만들겠다는 정의
    <Stack
      screenOptions={{
        // 앱의 헤더를 지우겠다.
        headerShown: false
      }}
    >
    </Stack>
  )
}

export default HomeLayout

const styles = StyleSheet.create({})