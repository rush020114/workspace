package book.promotion1;

public class CastingTest1 {
  public static void main(String[] args) {
    // 형변환을 시키려면 먼저 할당을 해놓고 형변환을 해야 한다. 아래의 경우처럼 바로 형변환시키면 오류가 난다.
    UniversityStudent lee = (UniversityStudent) new Student();

    // 먼저 자식 클래스를 할당시킨 후 그 부모클래스에게 강제형변환을 시켜야 성공한다.
    Student kim = new UniversityStudent();
    UniversityStudent park = (UniversityStudent) kim;
    System.out.println(park.major);
  }
}
