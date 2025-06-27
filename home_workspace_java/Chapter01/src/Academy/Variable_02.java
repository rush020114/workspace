public class Variable_02 {
  public static void main(String[] args){
    int count; // count라는 변수를 정수의 형태로 선언
    count = 10; // 10을 count변수에 저장

    System.out.println("count"); // 문자 출력이기 때문에 count
    System.out.println(count); // ""가 없으므로 변수의 값을 출력하라는 뜻이기 때문에 10
    System.out.println("count = " + count); // 문자와 숫자의 연산은 문자나열이므로 count = 10
    System.out.println("5" + count); // 문자와 숫자의 연산은 문자나열이므로 510
    System.out.println(5 + count); // 숫자와 숫자의 연산이므로 15
    System.out.println("변수 count의 값은 " + count + "입니다"); //문자와 숫자의 나열이므로 변수 count의 값은 5입니다
  }
}
