package Book;

public class MethodTest3 {
  private String name;
  private int score;
  private char grade;
  private boolean isPassed;

  // setter는 멤버변수에 값을 할당하는 메서드를 가리킨다.
  // getter는 멤버변수의 값을 받아 리턴하는 메서드를 가리킨다.

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public char getGrade() {
    return grade;
  }

  public void setGrade(char grade) {
    this.grade = grade;
  }

  public boolean isPassed() { // boolean타입의 getter는 isPassed로 자동생성된다.
    return isPassed;
  }

  public void setPassed(boolean passed) {
    isPassed = passed;
  }
}
