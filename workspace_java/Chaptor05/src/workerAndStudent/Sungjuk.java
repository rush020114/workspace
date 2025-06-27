package workerAndStudent;

public class Sungjuk {
  private int korScore;
  private int engScore;
  private int mathScore;
  private int sumSubjectScore;
  private double avgSubjectScore;

  public Sungjuk(int korScore, int engScore, int mathScore){
    this.korScore = korScore;
    this.engScore = engScore;
    this.mathScore = mathScore;
    this.sumSubjectScore = korScore + engScore + mathScore;
    this.avgSubjectScore = (korScore + engScore + mathScore) / 3.0;
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

  public int getSumSubjectScore() {
    return sumSubjectScore;
  }

  public void setSumSubjectScore(int sumSubjectScore) {
    this.sumSubjectScore = sumSubjectScore;
  }

  public double getAvgSubjectScore() {
    return avgSubjectScore;
  }

  public void setAvgSubjectScore(double avgSubjectScore) {
    this.avgSubjectScore = avgSubjectScore;
  }

  public void displaySungjukInfo(){
    System.out.println("국어점수 : " + korScore);
    System.out.println("영어점수 : " + engScore);
    System.out.println("수학점수 : " + mathScore);
    System.out.println("총점 : " + sumSubjectScore);
    System.out.println("평균 : " + avgSubjectScore);
  }
}
