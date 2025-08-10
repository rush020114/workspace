package grade06;

import java.util.Scanner;

public class Main06_05 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.next().toUpperCase();
    char[] chars = new char[26];
    int[] ints = new int[26];
    int[] newInts = new int[26];
    int alphabet = 'A';
    for(int i = 0 ; i < chars.length ; i++){
      chars[i] = (char)alphabet++;
    }
    for(int i = 0 ; i < str.length() ; i++){
      for(int j = 0 ; j < chars.length ; j++){
        if(str.charAt(i) == chars[j]){
          ints[j] += 1;
          newInts[j] += 1;
        }
      }
    }
    int max = -1;
    int index = -1;
    for(int i = 0 ; i < chars.length ; i++){
      if(max < ints[i]){
        max = ints[i];
        index = i;
      }
    }

    for(int i = 0 ; i < chars.length - 1 ; i++){
      for(int j = 0 ; j < chars.length - (i + 1) ; j++){
        if(newInts[j] > newInts[j + 1]){{
          int temp = newInts[j];
          newInts[j] = newInts[j + 1];
          newInts[j + 1] = temp;
        }}
      }
    }
    System.out.println(newInts[chars.length - 1] == newInts[chars.length - 2] ? "?" : chars[index]);
  }
}
