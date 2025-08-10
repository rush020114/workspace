package grade05;

import java.util.Scanner;

public class Main05_07 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    for(int k = 0 ; k < cnt ; k++){
      int count = sc.nextInt();
      String str = sc.next();
      String newStr = "";
      for(int i = 0 ; i < str.length() ; i++){
        for(int j = 0 ; j < count ; j++){
          newStr += str.substring(i, i + 1);
        }
      }
      System.out.println(newStr);
    }
  }
}
