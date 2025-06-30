package book.constructor;

public class ConstructorTest2 {
  public static void main(String[] args){
    // 객체 생성 및 초기화
    // 변수가 private이므로 객체가 변숫값을 변경할 수 없음.

    Student kim = new Student("김둘리", 100);
    kim.printInfo(); // 생성자는 원하는 멤버변수만 초기화할 수 있으므로 지정한 2개의 값만 초기화하고 나머지는 기본값으로 초기화.


    Student park = new Student("박또치", 100, true, "식품 영양학");

    park.printInfo();

  }
}
