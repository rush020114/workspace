import { FlatList, Keyboard, Pressable, StyleSheet, Text, TouchableWithoutFeedback, View } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import Button from '../../../components/common/Button'
import { useRouter } from 'expo-router'
import Input from '../../../components/common/Input'
import { colors } from '@/constants/colorConstant'
import FeedItem from '../../../components/home/FeedItem'
import { dummyData } from '../../../constants/dummy'

// app/(tabs)/(home)/index.jsx
// sns 목록 페이지
const HomeScreen = () => {
  const router = useRouter();

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