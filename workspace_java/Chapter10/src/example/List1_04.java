package example;

import java.util.ArrayList;
import java.util.List;

public class List1_04 {
  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();
    for(int i = 0 ; i < 10 ; i++){
      list.add((int)((Math.random() * 100) + 1));
    }
    int cnt = 0;
    for(Integer e : list){
      if(e % 2 == 0){
        cnt++;
        System.out.println(e);
      }
    }
    System.out.println(cnt);
  }
}
