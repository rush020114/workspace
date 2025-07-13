package academy.student;

public class Student {
  private String name;
  private int score;

  public Student(String name, int score){
    this.name = name;
    this.score = score;
  }

  public String getName(){
    return name;
  }

  public int getScore(){
    return score;
  }

  public String toString(){
    return "이름 : " + name + ", 점수 : " + score;
  }
}
