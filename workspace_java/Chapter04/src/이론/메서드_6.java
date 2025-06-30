package 이론;

public class 메서드_6 {
  public static void main(String[] args) {
    int sum = getSum(10, 20); // getSum을 호출하여 리턴받은 값을 sum에 저장
    System.out.println(sum);
    double avg = getAvg(10, 20);
    System.out.println(avg);
  }

  // 매개변수로 전달받은 두 정수의 합을 리턴
  public static int getSum(int a, int b) { // getSum메서드의 기능구현에 필요한 데이터
    int sum = a + b; // getSum메서드의 기능
    return sum; // 기능 실현 후 나온 데이터
  }

  // 매개변수로 전달받은 두 젇수의 평균을 리턴
  public static double getAvg(int a, int b){
    // double avg = (a + b) / 2.0; 아래의 코드 한 줄과 동일
    // 밑의 코드 해석 : getSum(a, b)는 main메서드의 getAvg의 호출을 받아 getAvg로 정의된 매서드의 기능을 사용하게 된다.
    // 이때 기능구현을 위해 필요한 데이터는 정수형 a, b변수 2개이다.(각각 10, 20으로 사용)
    // 그리고 double avg에 값을 저장하기 위해 getSum을 호출하게 되는데 변수 a, b의 값은 각각 10, 20으로 호출된다.
    // getSum의 기능은 두 변수를 더한 값을 돌려준 것이다.(return으로 우리에게 돌려줬으니 사용하면 됨.)
    // 그렇게 getSum(a, b)는 30이 된다.
    double avg = getSum(a, b) / 2.0;
    return avg;
  }

}
