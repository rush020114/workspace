package grade05;

import java.util.Scanner;

public class Main05_03 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int index = sc.nextInt();
    for(int i = 0 ; i < index ; i++){
      String str = sc.next();
      System.out.println(str.substring(0, 1) + str.substring(str.length() - 1));
    }
  }
}
