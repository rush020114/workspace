package example;

import java.util.Arrays;

public class MyArrayTest {
  public static void main(String[] args) {
    ArrayUtil myArr = new MyArray(); // 실무에서는 인터페이스 자료형으로 객체를 생성한다.
    MyArray myArray = new MyArray();
    int[] ints1 = {1, 4, 2, 3, 5};
    int[] ints2 = {2, 3, 5, 6, 4};
    System.out.println("배열의 모든 요소의 합 : " + myArr.getSumOfArray(new int[] {1, 4, 2, 3, 5}));
    System.out.println("두 배열의 모든 요소의 평균 : " + myArr.getAvgOfArray(ints1, ints2));

    System.out.println(Arrays.toString(myArr.getArrayOfEven(ints1)));
    System.out.println(Arrays.toString(myArr.getArrayOfEven(ints2)));
  }
}