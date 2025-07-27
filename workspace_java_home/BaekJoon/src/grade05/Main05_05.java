package grade05;

import java.util.Scanner;

public class Main05_05 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int cnt = sc.nextInt();
    String str = sc.next();

    int sum = 0;
    String[] strings = new String[str.length()];
    int[] ints = new int[str.length()];
    for(int i = 0 ; i < str.length() ; i++){
      strings[i] = str.substring(i, i + 1);
      ints[i] = Integer.parseInt(strings[i]);
      sum += ints[i];
    }
    System.out.println(sum);
  }
}
