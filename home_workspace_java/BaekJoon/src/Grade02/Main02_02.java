package Grade02;

import java.util.Scanner;

public class Main02_02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int score = sc.nextInt();
    int grade = score / 10;
    switch(grade){
      case 10 :
      case 9 :
        System.out.println('A');
        break;
      case 8 :
        System.out.println('B');
        break;
      case 7 :
        System.out.println('C');
        break;
      case 6 :
        System.out.println('D');
        break;
      default :
        System.out.println('F');
    }
  }
}
