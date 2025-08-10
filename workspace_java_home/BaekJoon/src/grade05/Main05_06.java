package grade05;

import java.util.Scanner;

public class Main05_06 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    String newStr = "";
    int[] ints = new int[26];
    int index = 0;
    for(int i = 0 ; i < 26 ; i++){
      ints[i] = -1;
    }
    for(int i = 0 ; i < str.length() ; i++){
      int cnt = 0;
      for(int j = 0 ; j < i ; j++){
        if(str.charAt(i) == str.charAt(j)){
          cnt++;
        }
      }
      if(cnt == 0){
        index++;
      }
    }
    int[] newInts = new int[index];
    index = 0;
    for(int i = 0 ; i < str.length() ; i++){
      int cnt = 0;
      for(int j = 0 ; j < i ; j++){
        if(str.charAt(i) == str.charAt(j)){
          cnt++;
        }
      }
      if(cnt == 0){
        newInts[index++] = i;
        newStr += str.substring(i, i + 1);
      }
    }
    for(int i = 0 ; i < newInts.length ; i++){
      ints[(newStr.charAt(i) - 'a')] = newInts[i];
    }
    for(int i = 0 ; i < ints.length ; i++){
      System.out.print(ints[i] + " ");
    }
  }
}
