package yoon;

public class MethodReturn2 {
  public static void main(String[] args){
    divide(9, 3);
    divide(6, 3);
    divide(6, 0);
  }

  public static void divide(int num1 , int num2){ // 리턴값이 없음이라는 리턴타입이 있어도 리턴을 사용할 수 있다.
    if(num2 == 0){
      System.out.println("0으로 나눌 수 없습니다.");
      return; // 메서드를 종료시키고 싶을 때 리턴을 사용하기도 한다.(메서드가 종료되지 않고 실행되면 밑의 문장과 3번째 호출문 때문에 오류가 생김.
    }
    System.out.println("나눗셈 결과 : " + (num1 / num2));
  }
}
