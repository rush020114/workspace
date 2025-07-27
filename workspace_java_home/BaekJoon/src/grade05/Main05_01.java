package grade05;

import java.util.Scanner;

public class Main05_01 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int num = sc.nextInt();
    System.out.println(str.substring(num - 1, num));
  }
}
