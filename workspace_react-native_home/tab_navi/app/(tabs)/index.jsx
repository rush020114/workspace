import { Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { useRouter } from 'expo-router'
import { SafeAreaView } from 'react-native-safe-area-context';

const HomeScreen = () => {
  // 페이지 이동 hook
  const router = useRouter();
  return (
    <SafeAreaView>
      <Text>HomeScreen</Text>
      <Pressable
        // 탭 구조 layout에서도 router 기반 페이지 이동 가능
        onPress={() => router.replace('/myPage')}
      >
        <Text>내 정보 페이지로 이동</Text>
      </Pressable>
    </SafeAreaView>
  )
}

export default HomeScreen

const styles = StyleSheet.create({})