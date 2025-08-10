package grade07;

import java.util.Scanner;

public class Main07_02 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[][] ints = new int[9][9];
    int max = -1;
    int row = 0;
    int col = 0;
    for(int i = 0 ; i < 9 ; i++){
      for(int j = 0 ; j < 9 ; j++){
        ints[i][j] = sc.nextInt();
      }
    }

    for(int i = 0 ; i < 9 ; i++){
      for(int j = 0 ; j < 9 ; j++){
        if(max < ints[i][j]){
          max = ints[i][j];
          row = i;
        }
      }
    }

    for(int i = 0 ; i < 9 ; i++){
      if(max == ints[row][i]){
        col = ++i;
      }
    }

    System.out.println(max);
    System.out.println(++row + " " + col);
  }
}
