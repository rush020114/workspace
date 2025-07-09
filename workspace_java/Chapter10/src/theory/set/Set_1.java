package theory.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set_1 {
  public static void main(String[] args){
    Set<Integer> integerSet = new HashSet<>();
    // 다수의 문자열을 저장할 통
    TreeSet<String> set = new TreeSet<>();
    set.add("java");
    set.add("python");
    set.add("c++");
    set.add("c++");
    System.out.println(set.size());

    for(String e : set){
      System.out.println(e);
    }
  }
}
