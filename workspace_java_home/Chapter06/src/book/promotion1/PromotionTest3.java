package book.promotion1;

public class PromotionTest3 {
  // Human 타입의 객체 4개를 저장할 수 있는 배열 생성 및 초기화
  // 서로 다른 객체인데 상속으로 묶어 배열에 저장할 수 있음
  public static void main(String[] args){
    Human[] humanList = {new Human(), new Student(), new UniversityStudent(), new HighStudent()};
  }
}
