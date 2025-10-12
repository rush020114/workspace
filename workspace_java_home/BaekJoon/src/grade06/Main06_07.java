package grade06;

import java.util.*;

public class Main06_07 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int cnt = sc.nextInt();
    int resultCnt = 0;
    String[] strings = new String[cnt];
    for(int i = 0 ; i < cnt ; i++){
      strings[i] = sc.next();
    }
    for(int i = 0 ; i < cnt ; i++){
      boolean isGroup = true;
      for(int j = 0 ; j < strings[i].length() ; j++){
        if(strings[i].indexOf(strings[i].charAt(j)) < j - 1){
          if(strings[i].charAt(j) != strings[i].charAt(j - 1)){
            isGroup = false;
            break;
          }
        }
      }
      if(isGroup){
        resultCnt++;
      }
    }
    System.out.println(resultCnt);
  }
}
