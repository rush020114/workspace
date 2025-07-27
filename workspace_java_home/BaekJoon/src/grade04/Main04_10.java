package grade04;

import java.util.Scanner;

public class Main04_10 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] ints = new int[sc.nextInt()];
    double[] newInts = new double[ints.length];
    for(int i = 0 ; i < ints.length ; i++){
      ints[i] = sc.nextInt();
    }

    int max = ints[0];
    for(int i = 0 ; i < ints.length ; i++){
      if(max < ints[i]){
        max = ints[i];
      }
    }
    double sum = 0;
    for(int i = 0  ; i < ints.length ; i++){
      newInts[i] = (double)ints[i] / max * 100;
      sum += newInts[i];
    }
    System.out.println(sum / ints.length);
  }
}
