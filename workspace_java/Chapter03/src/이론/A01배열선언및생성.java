package 이론;

public class A01배열선언및생성 {
  public static void main(String[] args){
    // 배열 선언 문법
    // 자료형[] 변수명;
    // 배열 생성 문법
    // 변수명 = new 자료형[정수]; 정수는 자료의 저장공간 개수를 지정

    // 정수를 여러개 저장할 수 있는 배열 arr1을 선언
    // 배열을 선언하면 안에 null이 들어가 있다. null은 데이터가 정의되지 않았다는 뜻
    int[] arr1;
    // arr1 배열을 정수가 3개 저장될 수 있는 공간으로 생성
    // int는 공간이 생성되면 모든 공간이 0으로 초기화
    arr1 = new int[3];

    // 문자열을 여러개 저장할 수 있는 배열 arr2를 선언
    String[] arr2;
    // arr2 배열을 문자열이 5개 저장될 수 있는 공간으로 생성
    // 문자열은 공간이 생성되면 모든 공간이 null으로 초기화
    arr2 = new String[5];

    double[] arr3;
    // 실수는 공간이 생성되면 모든 공간이 0.0으로 초기화
    arr3 = new double[7];
  }

  // 배열의 선언과 생성을 동시에!
  int[] arr4 = new int[4];
}
