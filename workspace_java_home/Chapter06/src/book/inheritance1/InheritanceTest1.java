package book.inheritance1;

public class InheritanceTest1 {
  public static void main(String[] args) {
    UniversityStudent kim = new UniversityStudent();
    kim.name = "김둘리"; // kim은 Student 클래스를 상속받았기 때문에 부모클래스의 멤버변수나 메서드를 사용할 수 있다.
    kim.setScore(83);
    kim.major = "컴퓨터 공학";
    System.out.println(kim.getName() + "의 점수 : " + kim.getScore());

    HighStudent park = new HighStudent();
    park.name = "박또치";
    park.setScore(100);
    park.classNumber = 6;
    System.out.println(park.getName() + "의 점수 : " + park.getScore());
  }
}
