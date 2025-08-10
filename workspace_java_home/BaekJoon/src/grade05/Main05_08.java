package grade05;

import java.util.Scanner;

public class Main05_08 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    int cnt = 0;
    for(int i = 0 ; i < str.length() ; i++){
      if(str.charAt(i) - ' ' == 0){
        cnt++;
      }
    }
    if(str.charAt(0) - ' ' == 0 && str.charAt(str.length() - 1) - ' ' == 0){
      cnt -= 2;
    }
    else if(str.charAt(0) - ' ' == 0 || str.charAt(str.length() - 1) - ' ' == 0){
      cnt--;
    }
    System.out.println(++cnt);
  }
}
