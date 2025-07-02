package grade03;

import java.util.Scanner;

public class Main03_05 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    for (int i = 0 ; i < num / 4 ; i++){
      if(num % 4 != 0){
        break;
      }

      else{
        System.out.print("long ");
      }
    }
    if(num % 4 == 0){
      System.out.println("int");
    }
  }
}
