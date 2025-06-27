package Book;

public class StudentTest {
  public static void main(String[] args){
    // Student 객체 생성 및 초기화(by 생성자)
    // Student 객체를 참조할 수 있는 참조변수에 Student 객체 저장.
    Student kim = new Student();
    kim.name = "둘리"; //  kim 참조변수를 통해 name에 "둘리" 저장
    // kim.score = 83; score가 private접근제한자이므로 사용할 수 없다.(지금은 풂)

    // student 객체의 요소 사용
    System.out.println("이름 : " + kim.name);
    // System.out.println("점수 : " + kim.score);
    kim.printInfo(); // kim 참조변수를 통해 printInfo 메서드 사용

  }
}
