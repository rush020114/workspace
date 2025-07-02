package academy;

public class MethodExampl04 {
  public static void main(String[] args){
    System.out.println(maxNum(3, 3)); // maxNum를 호출(리턴 값이 출력될 예정)
  }

  public static int maxNum(int num1, int num2){ // 매개변수로는 정수형을 두 개 받고, 리턴타입도 정수형이니 리턴을 정수형으로 작성.
    int max = Math.max(num1, num2); // 두 수의 크기를 비교하는 기능을 가진 메서드
    return max; // 이 리턴데이터는 이제부터 사용 가능(maxNum을 호출할 때 이 max값이 쓰임)
  }
}
