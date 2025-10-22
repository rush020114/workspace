import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import axios from 'axios'
import { TouchableWithoutFeedback } from 'react-native-web';
import { SafeAreaView } from 'react-native-safe-area-context';
import Button from '../../../components/common/Button';
import * as SecureStore from 'expo-secure-store'
import { useRouter } from 'expo-router';

// app/settings/index.jsx
// settings 탭을 터치하면 실행되는 페이지
const SettingsHomeScreen = () => {
  const router = useRouter();

  const getData1 = () => {
    console.log(1)
    axios.get().then(res => console.log(2)).catch();
    console.log(3)
  };
  // await, async 활용 문법
  // 비동기 실행 코드 앞에 await 키워드를 붙이면 비동기 코드가 동기로 실행
  // 함수 앞에 async를 붙이면 해당 함수가 비동기로 강제로 실행
  // 선언된 함수 안에 await가 붙은 코드가 있으면 
  // 해당 함수는 반드시 async를 붙여서 비동기 함수로 만들어줘야 함.
  const getData2 = async () => {
    console.log(1);
    try{
      // await로 동기가 되어 then, catch가 사라졌으므로 따로 데이터를 받아야 한다.
      const res = await axios.get();
      console.log(res.data);
    } catch(e) {
      console.log(e);
    }
    console.log(3);
  };

  const logout = async () => {
    // secureStore에 저장된 로그인 정보 삭제
    await SecureStore.deleteItemAsync('loginInfo')

    router.replace('/')
  }

  // react의 비동기 코드는 그림까지 다 그린 후 가장 마지막에 실행
  return (
    <TouchableWithoutFeedback>
      <SafeAreaView>
        <Button
          title='로그아웃'
          onPress={() => logout()}
        >

        </Button>
      </SafeAreaView>
    </TouchableWithoutFeedback>
  )
}

export default SettingsHomeScreen

const styles = StyleSheet.create({})