package 실습;

public class Cal {
  int num1;
  int num2;
  String oper;

  public void setNum(int num1, int num2){
    this.num1 = num1;
    this.num2 = num2;
  }

  public void setNum1(int num1){
    this.num1 = num1;
  }

  public void setNum2(int num2){
    this.num2 = num2;
  }

  public int getNum1(){
    return num1;
  }

  public int getnum2(){
    return num2;
  }
  // 더하기 결과를 리턴하는 메서드
  public int getSum(){
    return num1 + num2;
  }
  // 빼기 결과를 리턴하는 메서드
  public int getSub(){
    return num1 - num2;
  }
  // 곱하기 결과를 리턴하는 메서드
  public int getMulti(){
    return num1 * num2;
  }
  // 나누기 결과를 리턴하는 메서드
  public double getDiv(){
    return num1 / (double)num2;
  }
}
