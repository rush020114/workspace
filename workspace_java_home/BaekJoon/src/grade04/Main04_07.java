package grade04;

import java.util.Scanner;

public class Main04_07 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int[] arr1 = new int[30];
    for(int i = 0 ; i < arr1.length ; i++){
      arr1[i] = i + 1;
    }

    int[] arr2 = new int[28];
    for(int i = 0 ; i < arr2.length ; i++){
      arr2[i] = sc.nextInt();
    }

    int[] newArr = new int[2];
    int index = 0;
    for(int i = 0 ; i < arr1.length ; i++){
      int cnt = 0;
      for(int j = 0 ; j < arr2.length ; j++){
        if(arr1[i] == arr2[j]){
          cnt++;
        }
      }
      if(cnt == 0){
        newArr[index++] = arr1[i];
      }
    }

    for(int e : newArr){
      System.out.println(e);
    }
  }
}
