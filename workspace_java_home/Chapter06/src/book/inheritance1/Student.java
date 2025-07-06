package book.inheritance1;

// 비슷한 클래스가 생길 때마다 관련 코드를 모두 수정해야 하는 상황이 생긴다. 이 때문에 상속을 지원한다.
// 변수를 오버라이딩할 수 있지만 하지 않는다.
public class Student {
  String name;
  int score;

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public int getScore(){
    return score;
  }

  public void setScore(int score){
    this.score = score;
  }
}
