package example;

public class MyMath implements MathUtil{
  public MyMath(){

  }

  // 매개변수로 전달된 세 정수의 합이 짝수이면서,
  // 동시에 세 정수의 합이 5의 배수일 경우에만 return true;
  @Override
  public boolean isEven(int a, int b, int c){
    return (a + b + c) % 2 == 0 && (a + b + c) % 5 == 0 ? true : false;
  }

  // 1부터 매개변수로 받은 정수까지의 합을 리턴
  @Override
  public double getSumFromOne(int num){
    int sum = 0;
    for(int i = 1 ; i < num + 1 ; i++){
      sum += i;
    }
    return sum;
  }

  // 매개변수로 넘어오는 반지름을 갖는 원의 넓이를 리턴
  // 단, 매개변수로 전달된 반지름이 음수라면 원의 넓이는 0으로 리턴
  @Override
  public double getCircleArea(int rad){
    if(rad < 0){
      return 0;
    }

    else{
      return rad * rad * Math.PI;
    }
  }
}
