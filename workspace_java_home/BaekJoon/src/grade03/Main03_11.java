package grade03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main03_11 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    List<Integer> integerList = new ArrayList<>();
    while(true){
      int num1 = sc.nextInt();
      int num2 = sc.nextInt();
      if(num1 == 0 && num2 == 0){
        break;
      }
      integerList.add(num1 + num2);
    }
    for(int i = 0 ; i < integerList.size() ; i++){
      System.out.println(integerList.get(i));
    }
  }
}
