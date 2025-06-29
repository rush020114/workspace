package test1;

import java.util.Scanner;

public class Test1 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("첫번째 수 : ");
    int num1 = sc.nextInt();
    System.out.print("두번째 수 : ");
    int num2 = sc.nextInt();
    System.out.print("세번째 수 : ");
    int num3 = sc.nextInt();

    int max;
    int mid;
    int min;

    if(num1 > num2 && num1 > num3){
      max = num1;
      mid = Math.max(num2, num3);
      min = Math.min(num2, num3);
    }

    else if(num2 > num3 && num2 > num1){
      max = num2;
      mid = Math.max(num1, num3);
      min = Math.min(num1, num3);
    }

    else{
      max = num3;
      mid = Math.max(num1, num2);
      min = Math.min(num1, num2);
    }

    System.out.println(max + " > " + mid + " > " + min);
  }
}

