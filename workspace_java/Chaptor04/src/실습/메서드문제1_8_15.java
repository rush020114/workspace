package 실습;

import java.util.Scanner;

public class 메서드문제1_8_15 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("두 수 나열 : ");
    int1(sc.nextInt(), sc.nextInt());
    System.out.print("두 수 합 : ");
    int2(sc.nextInt(), sc.nextInt());
    System.out.print("홀짝 : ");
    int3(sc.nextInt());
    System.out.print("두 수의 홀짝 : ");
    int4(sc.nextInt(), sc.nextInt());
    System.out.print("0부터 입력한 수까지 : ");
    int5(sc.nextInt());
    System.out.print("두 수의 사이 : ");
    int6(sc.nextInt(), sc.nextInt());
    System.out.print("두 수의 사이에서 5의 배수 : ");
    int7(sc.nextInt(), sc.nextInt());
    System.out.print("숫자만큼 문자열 반복 : ");
    intAndString(sc.nextInt(), sc.next());
  }

  public static void int1(int int1_1, int int1_2){
    System.out.println(int1_1 + " " + int1_2);
  }
  public static void int2(int int2_1, int int2_2){
    System.out.println(int2_1 + int2_2);
  }
  public static void int3(int int3_1){
    if(int3_1 % 2 == 0){
      System.out.println("짝수입니다.");
    }
    else{
      System.out.println("홀수입니다.");
    }
  }
  public static void int4(int int4_1, int int4_2){
    if((int4_1 + int4_2) % 2 == 0){
      if(int4_1 % 2 == 0 && int4_2 % 2 == 0){
        System.out.println("두 수는 짝수입니다.");
      }
      if(int4_1 % 2 == 1 && int4_2 % 2 == 1){
        System.out.println("두 수는 홀수입니다.");
      }
    }
    else{
      System.out.println("한 수는 홀수입니다.");
    }
  }
  public static void int5(int int5_1){
    for(int i = 0 ; i < int5_1 + 1 ; i++){
      System.out.print(i + " ");
    }
    System.out.println();
  }
  public static void int6(int int6_1, int int6_2){
    if (int6_1 < int6_2) {
      for(int i = int6_1 + 1 ; i < int6_2 ; i++){
        System.out.print(i + " ");
      }
      System.out.println();
    }
    else if(int6_2 < int6_1){
      for(int i = int6_2 + 1 ; i < int6_1 ; i++){
        System.out.print(i + " ");
      }
      System.out.println();
    }
  }
  public static void int7(int int7_1, int int7_2){
    if (int7_1 < int7_2) {
      for(int i = int7_1 + 1 ; i < int7_2 ; i++){
        if(i % 5 == 0){
          System.out.print(i + " ");
        }
      }
      System.out.println();
    }
    else if(int7_2 < int7_1){
      for(int i = int7_2 + 1 ; i < int7_1 ; i++){
        if(i % 5 == 0){
          System.out.print(i + " ");
        }
      }
      System.out.println();
    }
  }
  public static void intAndString(int num, String string){
    for(int i = 0 ; i < num ; i++){
      System.out.print(string + " ");
    }
  }
}
