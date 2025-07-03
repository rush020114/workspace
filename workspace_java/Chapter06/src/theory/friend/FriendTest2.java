package theory.friend;

import java.util.ArrayList;
import java.util.List;

public class FriendTest2 {
  public static void main(String[] args) {
    List<Friend> friendList = new ArrayList<>();
    friendList.add(new UnivFriend("김", "111", "디자인"));
    friendList.add(new UnivFriend("이", "222", "생물"));
    friendList.add(new UnivFriend("박", "333", "천체"));
    friendList.add(new CompFriend("김", "123", "영업"));
    friendList.add(new CompFriend("최", "456", "회계"));
    friendList.add(new CompFriend("윤", "789", "인사"));

    for(Friend friend : friendList){
      friend.showInfo(); // 원래 다형성 때문에 부모 클래스의 기능만 실행되어야 하지만 오버라이딩 덕분에 자식에 접근하여 super로 부모까지 호출하며 모든 것을 출력한다.
    }
  }
}
