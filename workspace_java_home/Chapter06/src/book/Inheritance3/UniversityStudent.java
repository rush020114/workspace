package book.Inheritance3;

public class UniversityStudent extends Student {
  int score;

  // super(매개변수) : 부모클래스 생성자호출 <- 부모클래스의 매개변수와 동일해야 함.
  // 상속의 특성상 부모 클래스를 초기화하지 않으면 초기화되지 않은 멤버변수가 생길 수 있으므로 자식이 생성되면 부모도 자동으로 초기화될 수 있도록 super를 사용한다.
  // super()는 생략되어 항상 존재하지만 부모클래스의 매개변수에 따라 달라져야 한다.
  public UniversityStudent(String name, int score){
    super(name);
    this.score = score;
    System.out.println("===> UniversityStudent(String name, int score) 생성자 호출");
  }

  String printInfo(){ // UniversityStudent 객체를 사용해도 오버라이딩으로 자식 클래스밖에 접근이 안 되는데 super 키워드를 이용하여 부모 클래스도 접근할 수 있게 되었다.
    return super.printInfo() + ", 점수 : " + score;
  }
}