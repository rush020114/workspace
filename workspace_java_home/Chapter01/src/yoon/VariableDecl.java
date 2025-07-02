public class VariableDecl {
  public static void main(String[] args){
    double num1, num2; // 두 개의 변수를 동시에 선언, 하지만 관례적으로 한 개만 선언하는 것이 맞음
    num1 = 1.0000001;
    num2 = 2.0000001;
    double result = num1 + num2;
    System.out.println(result); // 실수는 컴퓨터 특성상 오차가 존재할 수밖에 없다.
  }
}
