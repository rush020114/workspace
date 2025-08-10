package grade07;

import java.util.Arrays;
import java.util.Scanner;

public class Main07_03 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String[] strings = new String[5];
    for(int i = 0 ; i < strings.length ; i++){
      strings[i] = sc.next();
    }

    System.out.println(Arrays.toString(strings));
    System.out.println(strings[1].substring(10, 11));
  }
}
