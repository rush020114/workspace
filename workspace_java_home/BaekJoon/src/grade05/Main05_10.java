package grade05;

import java.util.Scanner;

public class Main05_10 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int cnt = 0;
    for(int i = 0 ; i < str.length() ; i++){
      if(str.charAt(i) - 'A' >= 0 && str.charAt(i) - 'A' <= 2){
        cnt += 3;
      }

      if(str.charAt(i) - 'A' >= 3 && str.charAt(i) - 'A' <= 5){
        cnt += 4;
      }

      if(str.charAt(i) - 'A' >= 6 && str.charAt(i) - 'A' <= 8){
        cnt += 5;
      }

      if(str.charAt(i) - 'A' >= 9 && str.charAt(i) - 'A' <= 11){
        cnt += 6;
      }

      if(str.charAt(i) - 'A' >= 12 && str.charAt(i) - 'A' <= 14){
        cnt += 7;
      }

      if(str.charAt(i) - 'A' >= 15 && str.charAt(i) - 'A' <= 18){
        cnt += 8;
      }

      if(str.charAt(i) - 'A' >= 19 && str.charAt(i) - 'A' <= 21){
        cnt += 9;
      }

      if(str.charAt(i) - 'A' >= 22 && str.charAt(i) - 'A' <= 25){
        cnt += 10;
      }
    }
    System.out.println(cnt);
  }
}
