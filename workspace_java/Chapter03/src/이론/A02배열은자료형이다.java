package 이론;

public class A02배열은자료형이다 {
  public static void main(String[] args) {
    // 정수의 자료형이 배열의 자료형과 같다고 볼 수 없다.
    // 배열의 자료형이 지정되면 똑같은 배열이 아닌 이상 기본자료형이나 또 다른 자료형은 전부 다 다른 자료형이다.
    int a = 10;
    int[] arr1 = new int[3];

    String[] arr2 = new String[3];

    String[] arr3 = new String[10];
    arr3 = arr2; // 문법적으로는 가능
  }
}
