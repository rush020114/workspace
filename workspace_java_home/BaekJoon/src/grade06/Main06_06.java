package grade06;

import java.util.Scanner;

public class Main06_06 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    int cnt1 = 0;
    int cnt2 = 0;
    for(int i = 0 ; i < str.length() - 1 ; i++){
      if(str.substring(i, i + 2).equals("c=") || str.substring(i, i + 2).equals("c-") || str.substring(i, i + 2).equals("d-") || str.substring(i, i + 2).equals("lj") || str.substring(i, i + 2).equals("nj") || str.substring(i, i + 2).equals("s=") || str.substring(i, i + 2).equals("z=")){
        cnt1++;
      }
    }
    for(int i = 0 ; i < str.length() - 2; i++){
      if(str.substring(i, i + 3).equals("dz=")){
        cnt2++;
      }
    }
    if(cnt2 != 0){
      cnt1 -= cnt2;
    }
    System.out.println(cnt1 + cnt2 + str.length() - (cnt1 * 2 + cnt2 * 3));
  }
}
