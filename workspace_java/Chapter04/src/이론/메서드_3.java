package 이론;
// 매개변수는 있고 리턴 타입은 없는 메서드
// 매서드에 매개변수(기능을 위해 필요한 데이터)를 넣으면 호출할 때 매개변수 정보에 정수형이면 정수를 넣어야 한다.(두 개도 가능)
public class 메서드_3 {
  public static void main(String[] args){
    tellNum(5);
    tellNum(10);
    // tellNum("hi") 안됨
  }

  // 정수를 출력하는 기능의 메서드
  public static void tellNum(int num){
    System.out.println(num);
  }
}
