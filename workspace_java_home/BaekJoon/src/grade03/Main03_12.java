package grade03;

import java.util.Scanner;

public class Main03_12 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) { // hasNext메서드 : 입력된 값이 있으면 true 없으면 false
      System.out.println(sc.nextInt() + sc.nextInt());
    }
  }
}
