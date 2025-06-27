package 실습;
// 문자열 -> 정수 : int result1 = Integer.parseInt("");
// 정수 -> 문자열 : String result2 = String.valueOf(정수);

import java.util.Scanner;

public class 메서드문제2 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("두 수의 합 : ");
    System.out.println(getIntSum(10, 20));
    System.out.print("키보드 값으로 두 수의 곱 : ");
    System.out.println(getIntMulti(sc.nextInt(),sc.nextInt()));
    System.out.print("두 정수 중 큰 수 : ");
    System.out.println(getMax(20, 10));
    System.out.print("두 문자열 나열 : ");
    System.out.println(stringList("안녕","잘가"));
    System.out.print("점수에 따른 등급 : ");
    System.out.println(getGrade(95));
    System.out.print("정수를 문자열로 : ");
    System.out.println(getStr(10));
    System.out.print("실수를 제곱으로 : ");
    System.out.println(getSqu(2.2));
    System.out.print("세 정수의 평균 : ");
    System.out.println(getAvg(10, 22, 54));
    System.out.print("1부터 지정한 값까지 홀수의 덧셈 : ");
    System.out.println(getOdd(15));
    System.out.print("문자열 길이에 따른 참거짓 : ");
    System.out.println(getBool("안녕하세요!"));
  }

  public static int getIntSum(int num1, int num2){
    int sum = num1 + num2;
    return sum;
  }

  public static int getIntMulti(int num1, int num2){
    int multi = num1 * num2;
    return multi;
  }

  public static int getMax(int num1, int num2){
    if(num1 > num2){
      return num1;
    }
    else{
      return num2;
    }
  }
  public static String stringList(String str1, String str2){
    String list = str1 + str2;
    return list;
  }
  public static String getGrade(int num){
    if(num > 89){
      return "A";
    }
    else if(num > 69){
      return "B";
    }
    else{
      return "C";
    }
  }
  public static String getStr(int num){
    String str = String.valueOf(num);
    return str;
  }
  public static double getSqu(double num){
    double squ = num * num;
    return squ;
  }
  public static double getAvg(int num1, int num2, int num3){
    double avg = (num1 + num2 + num3) / 3.0;
    return avg;
  }
  public static int getOdd(int num){
    int sum = 0;
    for(int i = 1 ; i < num ; i++){
      if(i % 2 != 0){
        int odd = i;
        sum = sum + odd;
      }
    }
    return sum;
  }
  public static boolean getBool(String str){
    int length = str.length();
    if(length % 2 == 0){
      return true;
    }
    else{
      return false;
    }
  }
}
