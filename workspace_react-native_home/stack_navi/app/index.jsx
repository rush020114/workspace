import { Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { useRouter } from 'expo-router'
import { SafeAreaView } from 'react-native-safe-area-context';

// index는 최초 실행 파일이다.
// 파일 기반 페이지 이동은 url이 파일 이름이다.
const HomeScreen = () => {
  // 페이지 이동 시 사용할 변수
  // router.push : a -> b 일 때 a 가 남아 있음.
  // router.replace: a -> b일 때 a가 사라짐
  // router.navigate()
  const router = useRouter();
  return (
    // safeareaview를 모든 파일에 다 적용해주어야 한다.
    <SafeAreaView>
      <Text>홈 화면</Text>
      <View style={styles.btn_view}>
        <Pressable 
          style={styles.btn_press}
          // params로 페이지 이동 시 원하는 정보를 전달할 수 있다.
          onPress={() => router.push({
            pathname: '/detail'
            , params: {
              id: 'abc'
              , age: 20
            }
          })}
        >
          <Text>
            마이 페이지로 이동
          </Text>
        </Pressable>
        <Pressable 
          style={styles.btn_press}
          // params로 페이지 이동 시 원하는 정보를 전달할 수 있다.
          onPress={() => router.replace('/myPage')}
        >
          <Text>
            상세 페이지로 이동
          </Text>
        </Pressable>
      </View>
    </SafeAreaView>
  )
}

export default HomeScreen

const styles = StyleSheet.create({
  btn_view: {
    flexDirection: 'row',
    justifyContent: 'space-around'
  },
  btn_press: {
    borderWidth: 1,
    width: '40%',
    alignItems: 'center',
    padding: 10
  }
})