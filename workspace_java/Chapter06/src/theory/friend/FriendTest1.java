package theory.friend;

import java.util.ArrayList;
import java.util.List;

public class FriendTest1 {
  public static void main(String[] args){
    // 대학동창과 직장동료는 서로 다른 자료형이기 때문에 저장할 공간을 각각 생성(상속으로 하면 편하지만 다른 방법으로 시도)

    List<UnivFriend> uniList = new ArrayList<>();
    List<CompFriend> compList = new ArrayList<>();

    // 대학 동창 정보를 등록
    uniList.add(new UnivFriend("김자바", "010", "컴퓨터"));
    uniList.add(new UnivFriend("이자바", "011", "사회과학"));
    uniList.add(new UnivFriend("박자바", "012", "철학"));

    // 직장 동료 정보를 등록
    compList.add(new CompFriend("이순신", "111", "개발부"));
    compList.add(new CompFriend("유관순", "222", "인사부"));
    compList.add(new CompFriend("임꺽정", "333", "기획부"));

    for(UnivFriend univFriend : uniList){
      univFriend.showInfo();
    }

    for(int i = 0 ; i < compList.size() ; i++){
      compList.get(i).showInfo();
    }
  }
}
