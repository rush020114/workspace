package yoon;

public class Array01 {
  public static void main(String[] args) {
    // 배열 : 배열은 선언과 생성으로 변수를 사용할 수 있게 된다.
    // 선언하는 자료형 뒤에 []가 붙으면 int형 배열을 참조할 수 있는 변수가 된다. (따로 형성된 자료형)
    // 생성은 'new 자료형[저장 공간]'으로 이루어지고 저장공간에 들어간 수만큼 배열의 길이가 결정됨.
    // 배열은 인스턴스이다.
    int[] arr1 = new int[5]; // 길이가 5인 int형 배열 생성
    double[] arr2 = new double[7]; // 길이가 7인 double형 배열 생성
    // 배열의 선언과 생성 분리
    float[] arr3;
    arr3 =new float[9]; // 길이가 9인 float형 배열 생성(float이므로 실수 입력 후 f를 붙여야 한다.

    // 배열의 인스턴스 변수 접근
    System.out.println("배열 arr1의 길이 : " + arr1.length);
    System.out.println("배열 arr2의 길이 : " + arr2.length);
    System.out.println("배열 arr3의 길이 : " + arr3.length);

  }
}
