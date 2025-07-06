package book.promotion1;

public class PromotionTest2 {
  public static void main(String[] args){
    Human kim = new Human();
    kim = new Student();
    kim = new UniversityStudent();
    kim = new HighStudent();
    System.out.println(kim.age); // 변수 타입이 Human이므로 자식 객체를 할당받아도 Human밖에 사용 못함.
    Student park = new Student();
    park = new UniversityStudent();
    park = new HighStudent();
    System.out.println(park.age);
    System.out.println(park.score); // 마찬가지로 어떤 자식클래스를 할당받아도 자신 클래스 기능밖에 사용 못함.
  }
}
