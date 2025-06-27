package 이론;
// 변수는 해당 변수가 선언된 중괄호 안에서만 사용 가능하다.
public class 변수의사용영역 {
  public static void main(String[] args) {
    int[] arr = new int[3];
    // for문도 위치는 불편하지만 반복문의 중괄호라 생각하면 된다.
    for(int i = 0 ; i < arr.length; i++){
      arr[i] = 10;
    }
    for(int i = 0 ; i < arr.length ; i++){
      System.out.println(arr[i] + " ");
    }

    int num1 = 10;
    String name = "hong";
  }

  // 매개변수의 사용 영역은 메서드 정의문 안이다.
  public static void method1(int num){
    String name = "kim";
  }
  public static void method2(int num){
    String name = "kim";
  }
}
