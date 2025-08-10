package grade07;

import java.util.Scanner;

public class Main07_01 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int row = sc.nextInt();
    int col = sc.nextInt();
    int[][] ints1 = new int[row][col];
    int[][] ints2 = new int[row][col];

    for(int i = 0 ; i < ints1.length ; i++){
      for(int j = 0 ; j < ints1[i].length ; j++){
        ints1[i][j] = sc.nextInt();
      }
    }

    for(int i = 0 ; i < ints2.length ; i++){
      for(int j = 0 ; j < ints2[i].length ; j++){
        ints2[i][j] = sc.nextInt();
      }
    }

    for(int i = 0 ; i < ints1.length ; i++){
      for(int j = 0 ; j < ints1[i].length ; j++){
        System.out.print(ints1[i][j] + ints2[i][j] + " ");
      }
      System.out.println();
    }
  }
}
