package example;

public class Student {
  private String name;
  private int korScore;
  private int engScore;
  private int mathScore;
  private int sumScore;

  public Student(String name, int korScore, int engScore, int mathScore) {
    this.name = name;
    this.korScore = korScore;
    this.engScore = engScore;
    this.mathScore = mathScore;
    sumScore = korScore + engScore + mathScore;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getKorScore() {
    return korScore;
  }

  public void setKorScore(int korScore) {
    this.korScore = korScore;
  }

  public int getEngScore() {
    return engScore;
  }

  public void setEngScore(int engScore) {
    this.engScore = engScore;
  }

  public int getMathScore() {
    return mathScore;
  }

  public void setMathScore(int mathScore) {
    this.mathScore = mathScore;
  }

  public int getSumScore() {
    return sumScore;
  }

  public void setSumScore(int sumScore) {
    this.sumScore = sumScore;
  }

  @Override
  public String toString() {
    return "Student{" +
            "name='" + name + '\'' +
            ", korScore=" + korScore +
            ", engScore=" + engScore +
            ", mathScore=" + mathScore +
            ", sumScore=" + sumScore +
            '}';
  }
}
