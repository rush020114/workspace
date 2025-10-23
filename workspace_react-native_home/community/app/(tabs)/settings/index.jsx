import { StyleSheet, Text, TouchableWithoutFeedback, View } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import Button from '../../../components/common/Button'
import * as SecureStore from 'expo-secure-store'
import { router } from 'expo-router'

const SettingsHomeScreen = () => {

  const logout = async () => {
    await SecureStore.deleteItemAsync('loginInfo')

    if(router.canDismiss()){
      router.dismissAll();
    }
    router.replace('/')
  }
  
  return (
    <TouchableWithoutFeedback>
      <SafeAreaView>
        <Button 
          title='로그아웃'
          onPress={() => logout()}
        />
      </SafeAreaView>
    </TouchableWithoutFeedback>
  )
}

export default SettingsHomeScreen

const styles = StyleSheet.create({})