import { FlatList, Keyboard, Pressable, StyleSheet, Text, TouchableWithoutFeedback, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import Button from '../../../components/common/Button'
import { useRouter } from 'expo-router'
import Input from '../../../components/common/Input'
import { colors } from '@/constants/colorConstant'
import FeedItem from '../../../components/home/FeedItem'
import { dummyData } from '../../../constants/dummy'
import * as SecureStore from 'expo-secure-store'

// 로그인
// 앱에서는 로그인 정보를 휴대폰 안의 secureStore 공간에 저장

// secoureStore 사용을 위해 우선 라이브러리 설치 필요
// -> npx expo install expo-secure-store
// 1. 프로젝트 실행 시 HomeScreen이 실행
// 2. HomeScreen이 실행되자마자 로그인 여부를 확인
// 3. 만약 로그인이 안됐다면 바로 로그인 페이지로 강제 이동
// * secureStore에 저장된 데이터는 폰 초기화, 직접 로그아웃을 하지 않는 이상 영구적으로 보관, 문자열 데이터만 저장 가능

// secureStore 사용 방법
// 라이브러리 import -> import * as SecureStore from 'expo-secure-store'
// 데이터 저장 -> await SecureStore.setItemAsync('key', 'value')
// 데이터 조회 -> await SecureStore.getItemAsync('key')
// 데이터 삭제 -> await SecureStore.deleteItemAsync('key')

// app/(tabs)/(home)/index.jsx
// sns 목록 페이지
const HomeScreen = () => {
  const router = useRouter();

  // 로그인 정보 여부 확인
  useEffect(() => {
    const getLoginInfo = async () => {
      // secureStore에 저장된 로그인 정보를 가져옴
      const loginInfo = await SecureStore.getItemAsync('loginInfo');
      
      // 가져온 데이터를 원래 형태인 객체로 변환
      const loginData = JSON.parse(loginInfo);
  
      console.log('로그인 데이터 = ', loginData)

      // 로그인되어 있지 않다면
      if(!loginData){
        router.replace('/auth/login')
      }

    }
    getLoginInfo();
  }, []);

  const feedList = dummyData;

  return (
    <TouchableWithoutFeedback
      onPress={() => Keyboard.dismiss()}
    >
      <SafeAreaView 
        style={styles.container}
      >

        <Pressable onPress={() => router.push('/profile')}>
          <Text>
            제어 페이지로 이동
          </Text>
        </Pressable>

        <Pressable onPress={() => router.push('/auth/login')}>
          <Text>
            로그인 페이지로 이동
          </Text>
        </Pressable>

        <FlatList 
          // 반복할 데이터
          data={feedList}
          // 데이터 하나하나 실행할 코드
          renderItem={({item}) => <FeedItem item={item} />}
          // 반복 돌릴 아이템의 key값, 매개변수는 데이터 각각을 의미
          keyExtractor={(item) => item.id}
          // 리스트 영역의 디자인
          contentContainerStyle={styles.listContainer}
        />

        {/* 실무에서는 동일한 기능을 컴포넌트로 자주 만듦 */}
      </SafeAreaView>
    </TouchableWithoutFeedback>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  container: {
    flex: 1
    , backgroundColor: colors.WHITE
  },
  listContainer: {
    gap: 8,
    backgroundColor: colors.GRAY_200,
    paddingVertical: 8,
    paddingHorizontal: 6
  }
})