import { FlatList, Keyboard, Pressable, StyleSheet, Text, TouchableWithoutFeedback, View } from 'react-native'
import React from 'react'
import { SafeAreaView } from 'react-native-safe-area-context'
import { useRouter } from 'expo-router'
import { colors } from '@/constants/colorConstant'
import { dummyData } from '../../../constants/dummy'
import FeedItem from '../../../components/home/FeedItem'

// app은 app에 있는 index.jsx파일을 1순위로 실행한다. app에 index가 없으면 실행을 못한다.
// 이 컴포넌트의 위치는 앱과 함께 위치돼 있지 않지만 폴더가 ()로 감싸져 있기 때문에
// 경로가 무시되어 app과 함께 구성된다고 인식한다.
const HomeScreen = () => {
  const router = useRouter();

  const feedList = dummyData;

  return (
    // 이 컴포넌트는 기능이 없는 다른 영역도 터치 가능하게 해
    // 키보드가 다른 영역 터치 시 사라지게 하는 것도 가능하다.
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
          // 보여줄 데이터
          renderItem={({item}) => <FeedItem item={item} />}
          // key 값
          keyExtractor={item => item.id}
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