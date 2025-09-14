package grade06;

import java.util.*;

public class Main06_07 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int index = sc.nextInt();
    String[] strings = new String[index];
    for(int i = 0 ; i < index ; i++){
      strings[i] = sc.next();
    }

    int resultCnt = index;
    for(int i = 0 ; i < index ; i++){
      Set<Character> set = new LinkedHashSet<>();
      for(char c : strings[i].toCharArray()){
        set.add(c);
      }

      StringBuilder sb = new StringBuilder();
      for(Character c : set){
        sb.append(c);
      }
      List<Integer> integerList = new ArrayList<>();
      for(int j = 0 ; j < strings[i].length() ; j++){
        for(int k = 0 ; k < sb.length() ; k++){
          if(strings[i].charAt(j) == sb.charAt(k)){
            integerList.add(j);
            System.out.println(strings[i].charAt(j));
            System.out.println(sb.charAt(k));
          }
        }
        if(integerList.size() >= 2){
          if(integerList.get(1) - integerList.get(0) >= 2){
            resultCnt--;
            break;
          }
        }
      }
    }
    System.out.println(resultCnt);
  }
}
