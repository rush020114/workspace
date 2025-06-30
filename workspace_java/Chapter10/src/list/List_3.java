package list;

import java.util.ArrayList;
import java.util.List;

public class List_3 {
  public static void main(String[] args){
    /*Fruit f = new Fruit("오렌지", "제주도", 1000);

    System.out.println(f.toString());
    System.out.println(f); // toString 메서드를 넣어줌으로써 편하게 출력할 수 있다.*/

    List<Fruit> fruitList = new ArrayList<>();

    // 객체 생성 & 리스트에 객체 저장
    fruitList.add(new Fruit("바나나", "베트남", 1000));
    fruitList.add(new Fruit("사과", "한국", 2000));
    fruitList.add(new Fruit("딸기", "한국", 3000));
    fruitList.add(new Fruit("망고", "태국", 4000));
    fruitList.add(new Fruit("파인애플", "베트남", 4000));


    // fruitList에 저장된 모든 과일의 이름, 원산지, 가격을 출력하는 코드
    for(int i = 0 ; i < fruitList.size() ; i++){
      System.out.println(fruitList.get(i)); // 출력 메서드 생략 가능
    }

    for(Fruit e : fruitList){
      System.out.println(e);
    }
  }
}
