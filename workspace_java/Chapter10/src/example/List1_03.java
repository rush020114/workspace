package example;

import java.util.ArrayList;
import java.util.List;

public class List1_03 {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();

    list.add("김길동");
    list.add("박길동");
    list.add("홍길동");

    for(String e : list){
      if(e.equals("홍길동")){
        System.out.println("해당 이름이 존재합니다.");
      }
    }
  }
}
