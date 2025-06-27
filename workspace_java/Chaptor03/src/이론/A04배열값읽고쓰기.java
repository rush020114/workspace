package 이론;

public class A04배열값읽고쓰기 {
  public static void main(String[] args) {
    // 배열의 값을 읽을 때는 배열명을 출력해서는 안 됨!!!
    // 배열에 저장된 값을 읽을 때는 배열의 요소까지 작성해야 함
    // 배열 생성을 통해 만들어진 각각의 공간을 배열의 요소라 부른다.
    // 배열의 요소는 0부터 시작한다.
    // 공간이 3개 있으면 '변수열[0]'을 배열의 0번째 요소라 하고 처음의 공간에 위치하는 것이다.
    // 그러니 마지막 요소는 변수열[저장공간 - 1]이 되는 것이고 마지막 공간에 위치하는 것이다.

    // 1, 3, 5로 초기화된 데이터를 갖는 배열 arr1 생성
    int[] arr1 = {1, 3, 5};
    System.out.println(arr1); // 컴퓨터는 arr1자체를 출력하라는 말을 이해하지 못한다.
    System.out.println(arr1[0]);

    int[] arr2 = new int[3];
    System.out.println(arr2);
    System.out.println(arr2[2]);
    // System.out.println(arr2[3]); 배열 범위 벗어남!

    String[] arr3 = new String[5];
    System.out.println(arr3[2]);

    // 배열의 값을 변경, 등록할 때도 배열의 각 요소로 접근해서 넣는다.
    arr3[3] = "java"; // 문자열 배열의 요소는 문자열이므로 문자열 저장가능
    System.out.println(arr3[3]);

  }
}
