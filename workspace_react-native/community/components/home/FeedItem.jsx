import { Pressable, StyleSheet, Text, View } from 'react-native'
import React from 'react'
import Octicons from '@expo/vector-icons/Octicons';
import { colors } from '@/constants/colorConstant'
import Profile from './Profile';

// 게시글 컴포넌트
const FeedItem = ({item}) => {
  return (
    <View style={styles.feedContainer}>
      <Profile 
        writer={item.writer}
        createDate={item.createDate}
      />
      <Text style={styles.title}>{item.title}</Text>
      <Text style={styles.content}>{item.content}</Text>
      <View style={styles.menuContainer}>
        <Pressable style={styles.menu}>
          <Octicons name="heart" size={20} color="red" />
          <Text>{item.likeCnt}</Text>
        </Pressable>
        <Pressable style={styles.menu}>
          <Octicons name="comment" size={20} color="black" />
          <Text>{item.replyCnt}</Text>
        </Pressable>
        <Pressable style={styles.menu}>
          <Octicons name="eye" size={20} color="black" />
          <Text>{item.readCnt}</Text>
        </Pressable>
      </View>
    </View>
  )
}

export default FeedItem

const styles = StyleSheet.create({
  feedContainer: {
    padding: 16,
    backgroundColor: colors.WHITE
  },
  title: {
    fontSize: 16,
    marginBottom: 12
  },
  content: {
    fontSize: 14,
    color: colors.GRAY_600,
    marginBottom: 14
  },
  menuContainer: {
    flexDirection: 'row',
    justifyContent: 'space-around',
    alignItems: 'center',
    borderTopWidth: StyleSheet.hairlineWidth
  },
  menu: {
    flexDirection: 'row',
    justifyContent: 'center',
    gap: 6,
    paddingVertical: 10,
    width: '33.33%',
  }
})