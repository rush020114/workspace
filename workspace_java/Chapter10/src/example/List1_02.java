package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class List1_02 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    list.add(sc.nextInt());
    list.add(sc.nextInt());
    list.add(sc.nextInt());
    list.add(sc.nextInt());
    list.add(sc.nextInt());
    int sum = 0;
    for(Integer e : list){
      sum += e;
    }
    System.out.println(sum);
  }
}
