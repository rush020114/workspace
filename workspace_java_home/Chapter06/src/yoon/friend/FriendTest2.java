package yoon.friend;

public class FriendTest2 {
  public static void main(String[] args){
    Friend[] friends = new Friend[5];
    int friendCnt = 0;
    friends[friendCnt++] = new UnivFriend("lee", "computer", "010"); // UnivFriend는 Friend클래스를 상속했으므로 참조할 수 있는 형태이다.
    friends[friendCnt++] = new UnivFriend("seo", "electronics", "011"); // 이런 상속으로 인해 서로 다른 클래스를 공동으로 묶어 사용할 수 있게 된다.
    friends[friendCnt++] = new CompFriend("yoon", "r&d1", "012");
    friends[friendCnt++] = new CompFriend("park", "r&d2", "013");

    for(int i = 0 ; i < friendCnt ; i++){
      friends[i].show(); // 지금의 상태로는 부모 클래스인 Friend 클래스밖에 사용하지 못하지만 현재 자식 클래스의 메서드를 오버라이딩해놨으므로 자식 클래스를 호출할 수 있다.
    }
  }
}
