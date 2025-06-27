package 이론;

public class PhoneTest {
  public static void main(String[] args){
    // Phone클래스에 대한 객체 p1을 생성
    Phone p1 = new Phone();
    // p1 객체의 모델명을 출력
    System.out.println(p1.modelName);
    // p1 객체의 모델명, 가격, os 정보를 출력
    p1.checkPhoneInfo();
    // p1 객체의 가격을 1000원으로 변경
    p1.setPrice(1000);
    System.out.println(p1.price);
  }
}
