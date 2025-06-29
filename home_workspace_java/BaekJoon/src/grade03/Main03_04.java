package grade03;

import java.util.Scanner;

public class Main03_04 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int total = sc.nextInt();
    int productCnt = sc.nextInt();
    int[] productsCnt = new int[productCnt];
    int[] productsAmount = new int[productCnt];
    int sum = 0;
    for(int i = 0 ; i < productCnt ; i++){
      productsCnt[i] = sc.nextInt();
      productsAmount[i] = sc.nextInt();
      sum += (productsCnt[i] * productsAmount[i]);
    }

    if(sum == total){
      System.out.println("Yes");
    }

    else {
      System.out.println("No");
    }
  }
}
