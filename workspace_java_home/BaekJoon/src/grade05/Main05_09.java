package grade05;

import java.util.Scanner;

public class Main05_09 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num1 = sc.nextInt();
    int num2 = sc.nextInt();
    String str1 = "";
    String str2 = "";
    String newStr1 = str1 + num1;
    String newStr2 = str2 + num2;
    String newNewStr1 = "";
    String newNewStr2 = "";
    for(int i = 2 ; i > -1 ; i--){
      newNewStr1 += newStr1.charAt(i);
      newNewStr2 += newStr2.charAt(i);
    }
    int newNum1 = Integer.parseInt(newNewStr1);
    int newNum2 = Integer.parseInt(newNewStr2);
    System.out.println(Math.max(newNum1, newNum2));
  }
}
