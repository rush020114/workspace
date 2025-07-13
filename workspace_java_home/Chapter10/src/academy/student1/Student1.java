package academy.student1;

public class Student1 {
  private String name;
  private int age;
  private int score;

  public Student1(String name, int age, int score){
    this.name = name;
    this.age = age;
    this.score = score;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String toString(){
    return "이름 : " + name + ", 나이 : " + age + ", 점수 : " + score;
  }
}
