package book.promotion1;

public class PromotionTest1 {
  public static void main(String[] args) {
    Student kim = new UniversityStudent(); // 자식 개체는 부모 변수에 할당될 수 있다.
    // UniversityStudent kim1 = new Student(); <- 데이터가 부족한 객체가 할당되어 오류 발생.
    // System.out.println("전공 : " + kim.major); kim변수는 UniversityStudent를 받았지만 본인은 Student이기 때문에 자식을 사용할 수 없다.
    System.out.println("점수 : " + kim.score);
  }
}
