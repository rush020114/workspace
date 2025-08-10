package grade06;

import java.util.Scanner;

public class Main06_04 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int cnt = 0;
    for(int i = 0 ; i < str.length() / 2 ; i++){
      if(str.charAt(i) == str.charAt(str.length() - (i + 1))){
        cnt++;
      }
    }
    System.out.println(cnt == str.length() / 2 ? 1 : 0);
  }
}
