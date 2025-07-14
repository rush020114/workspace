package academy.person;

public class Sungjuk extends PersonInfo {
  private int korScore;
  private int engScore;
  private int mathScore;
  private int totalScore;
  private double avgScore;

  public Sungjuk(String name, int age, String addr, int korScore, int engScore, int mathScore){
    super(name, age, addr);
    this.korScore = korScore;
    this.engScore = engScore;
    this.mathScore = mathScore;
    totalScore = korScore + engScore + mathScore;
    avgScore = totalScore / 3.0;
  }

  public String toString(){
    return super.toString() + ", 국어점수 : " + korScore + ", 영어점수 : " + engScore + ", 수학점수 : " + mathScore + ", 총점 : " + totalScore + ", 평균 : " + avgScore;
  }
}
