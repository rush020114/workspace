package Yoon;
// 변수의 영역은 중괄호 안이다.
// 변수가 더 큰 범위의 중괄호 안에 또 포함되면 사용하지 못한다.
// 메서드나 for문에서 괄호 안에 변수가 선언되기도 하지만 그 중괄호 안의 영역이라고 보면 된다.
public class VariableScope {
  public static void main(String[] args){
    boolean ste = true;
    int num = 11;
    if(true){
      // int num = 11;
      // num++;
      // System.out.println(num1);
    }
    {
      int num2 = 33;
      num2++;
      System.out.println(num2);
    }
    for(int num3 = 1 ; num3 < 5 ; num3++){}
  }
  public static void myFunc(int num){}
}
