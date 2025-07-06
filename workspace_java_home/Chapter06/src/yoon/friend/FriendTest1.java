package yoon.friend;

// 이런 코드는 자료형이 다르기 때문에 저장하기 복잡해진다.
// CompFriend와 UnivFriend는 다른 자료형이지만 공통되게 묶을 수 있기 때문에 상속을 해주어 저장하기 어려운 문제를 해결할 수 있다.
public class FriendTest1 {
  public static void main(String[] args){
    UnivFriend[] univFriends = new UnivFriend[2];
    int ucnt = 0;
    CompFriend[] compFriends = new CompFriend[2];
    int ccnt = 0;

    univFriends[ucnt++] = new UnivFriend("lee", "computer", "010");
    univFriends[ucnt++] = new UnivFriend("seo", "electronics", "011");
    compFriends[ccnt++] = new CompFriend("yoon", "r&d1", "012");
    compFriends[ccnt++] = new CompFriend("park", "r&d2", "013");

    for(UnivFriend univFriend : univFriends){
      univFriend.show();
    }

    for(int i = 0 ; i < compFriends.length ; i++){
      compFriends[i].show();
    }
  }
}
