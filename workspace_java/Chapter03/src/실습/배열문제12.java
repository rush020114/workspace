package 실습;

import java.util.Scanner;

public class 배열문제12 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int[] arr1 = new int[3];
    String[] arr2 = {"국어", "영어", "수학"};
    int sum = 0;
    for(int i = 0 ; i < arr1.length ; i++){
      System.out.print(arr2[i] + "점수를 입력하시오. : ");
      arr1[i] = sc.nextInt();
      sum = sum + arr1[i];
    }
    System.out.println(sum);
    /*if(sum % 3 == 0){
      System.out.println(sum / 3);
    }
    if(sum % 3 != 0){
      System.out.println(sum / 3.0);
    }*/
    System.out.println(sum % 3 == 0 ? sum / 3 : sum / 3.0); // 삼항연산자는 자료형이 같지 않으면 더 넓은 데이터로 형변환되어 출력된다.
  }
}
