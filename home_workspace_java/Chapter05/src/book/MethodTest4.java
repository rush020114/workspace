package book;

public class MethodTest4 {
  // 메서드 오버로딩 : 하나의 클래스에 같은 이름의 메서드를 중복 선언할 수 있음.
  // 메서드의 매개변수 개수가 다르거나 매개변수 타입이 다르면 중복 선언 가능.

  public static void main(String[] args){
    Student kim = new Student();
    int result = kim.printAvg(83, 77);
    System.out.println("두 과목의 평균 점수 : " + result);

    result = kim.printAvg(83, 33.3, 34); // 같은 이름의 메서드를 사용하여 헷갈리지 않게 평균을 구할 수 있다.
    System.out.println("세 과목의 평균 점수 : " + result);

    result = kim.printAvg(83.2, 99);
      System.out.println("두 과목의 평균 점수 :" + result);
  }

}
