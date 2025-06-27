package Yoon;

public class Conversion {
  public static void main(String[] args){
    long n1 = 20000000000L; // 자바는 정수 입력을 int로 보아 그 범위를 넘어기면 L을 써준다.
    int n2 = (int)10000000000L; // int형에 저장돼야 하므로 강제 형변환, 하지만 데이터 손실 발생.
    System.out.println(n1 + n2); // int와 long의 연산은 long(더 넓은 범위이므로)으로 자동형변환되어 나옴.

    short n5 = (short)(10000 + 30000); // 두 개의 int를 연산할 때 short로 강제 변환하는 방법
    System.out.println(n5); // short의 범위를 벗어나지만 강제 형변환으로 데이터를 손실시키고 결과 출력
  }
}
