package theory.set;

import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class Set_2 {
  public static void main(String[] args) {
    Set<Integer> lotto = new TreeSet<>();

    while(true){
      if(lotto.size() < 6){
        lotto.add((int)((Math.random() * 45) + 1));
      }
      else{
        break;
      }
    }

    for(Integer e : lotto){
      System.out.print(e + " ");
    }
  }
}
