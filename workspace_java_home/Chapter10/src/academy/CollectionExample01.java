package academy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionExample01 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    // List는 인터페이스이고 ArrayList는 그 인터페이스를 구현한 클래스이다.
    // 그래서 List는 ArrayList를 객체로 받을 수 있고 구현한 메서드를 사용할 수 있다.
    // List를 구현한 메서드는 ArrayList뿐만 있는 것이 아니니 그 클래스들도 객체로 줄 수 있다.
    // 객체로 주어도 메서드 같은 인터페이스를 구현했으니 기능에 대한 구현은 약간 다를지라도
    // 메서드명을 똑같이 해서 사용할 수 있다.
    List<String> stringList1 = new ArrayList<>();
    stringList1.add("김");
    stringList1.add("이");
    stringList1.add("박"); // 이 변수가 참조하는 클래스에는 김,이,박 문자열이 들어있다.
    for(String e : stringList1){
      System.out.println(e);
    }

    List<Integer> integerList1 = new ArrayList<>();
    System.out.print("정수 5개 입력 : ");
    for(int i = 0 ; i < 5 ; i++){
      integerList1.add(sc.nextInt());
    }
    int sum = 0;
    for(int i = 0 ; i < integerList1.size() ; i++){
      sum += integerList1.get(i);
    }
    System.out.println("리스트 속 5개 정수의 총합 : " + sum);

    List<String> stringList2 = new ArrayList<>();
    stringList2.add("김길동");
    stringList2.add("이길동");
    stringList2.add("박길동");
    stringList2.add("최길동");
    stringList2.add("정길동");

    for(String e : stringList2){
      if(e.equals("홍길동")){
        System.out.println("해당이름이 존재합니다.");
        return;
      }
    }

    List<Integer> integerList2 = new ArrayList<>();
    int cnt = 0;
    for(int i = 0 ; i < 10 ; i++){
      integerList2.add((int)(Math.random() * 100 + 1));
      if(integerList2.get(i) % 2 == 0){
        System.out.println(integerList2.get(i));
        cnt++;
      }
    }
    System.out.println("짝수의 개수 : " + cnt);
  }
}
