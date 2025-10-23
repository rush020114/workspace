import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { TouchableWithoutFeedback } from 'react-native'
import { SafeAreaView } from 'react-native-safe-area-context'
import Input from '../../components/common/Input'
import Button from '../../components/common/Button'
import { useRouter } from 'expo-router'
import * as SecureStore from 'expo-secure-store'

const LoginScreen = () => {
  const router =useRouter();

  // 로그인 함수
  const login = async () => {
    // 로그인 정보 조회 가정
    const loginInfo = {
      userId: 'java'
      , userName: 'kim'
      , userRole: 'ADMIN'
    }

    await SecureStore.setItemAsync('loginInfo', JSON.stringify(loginInfo));

    if(router.canDismiss()){
      router.dismissAll();
    }
    router.replace('/')
  }
  
  return (
    <TouchableWithoutFeedback>
      <SafeAreaView>
        <Input 
          label='아이디'
        />
        <Input 
          label='비밀번호'
          isPw={true}
        />
        <Button 
          title='로그인'
          onPress={() => login()}
        />
      </SafeAreaView>
    </TouchableWithoutFeedback>
  )
}

export default LoginScreen

const styles = StyleSheet.create({})