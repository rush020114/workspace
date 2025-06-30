package book.constructor;

public class Student {
  // 생성자는 객체의 멤버변수 초기화를 담당하는 특수목적 메서드이다.

  // private 접근제한자를 달아줌으로써 처음 객체가 생성될 때 생성자를 통해 설정된 초깃값 외의 값을 가질 수 없게 된다.
  private String name;
  private int score;
  private boolean isPassed;
  private String major;

  // 기본 생성자 : 객체가 생성되면 기본값으로 초기화해준다.
  public Student(){
  }

  // this 키워드는 객체에 포함된 멤버변수와 메서드를 참조할 수 있다.
  // this 키워드를 사용함으로써 매개변수명에 대한 고민을 줄일 수 있다.
  public Student(String Name, int Score, boolean IsPassed, String major){
    this.name = Name;
    this.score = Score;
    this.isPassed = IsPassed;
    this.major = major;
  }

  // 매서드와 마찬가지로 생성자도 같은 조건에 오버로딩이 가능하다.
  public Student(String stdName, int stdScore){
    name = stdName;
    score = stdScore;
  }

  public void printInfo(){
    System.out.println(name + "의 전공 : " + major + ", 점수 : " + score + "( 시험 통과 여부 : " + isPassed + ")");
  }
}
