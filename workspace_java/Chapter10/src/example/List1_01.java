package example;

import java.util.ArrayList;
import java.util.List;

public class List1_01 {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    for(String e : list){
      System.out.println(e);
    }
  }
}
