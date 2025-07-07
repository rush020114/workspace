package example;

public class MyStudent implements StudentUtil{

  // 매개변수로 전달되는 학생의 총점을 리턴
  @Override
  public int getTotalScore(Student student) {
    return student.getKorScore() + student.getEngScore() + student.getMathScore();
  }

  // 매개변수로 전달된 두 명의 학생 중
  // 총점이 높은 학생을 리턴
  @Override
  public Student getHighScoreStudent(Student student1, Student student2) {
    return getTotalScore(student1) > getTotalScore(student2) ? student1 : student2;
  }

  // 학생 여러명을 매개변수로 받아 또 다른 매개변수로 받는 학생의 이름과
  // 일치하는 학생의 점수 등급을 문자열로 리턴
  // 학생의 점수 등급은 총점의 평균으로 계산.
  // 만약, 매개변수로 받은 이름가 일치하는 학생이 없다면
  // "학생 없음"이라는 문자열 리턴
  // 90 < 평균 <= 100 -> "A"
  // 80 <= 평균 <= 90 -> "B"
  // 70 <= 평균 <= 80 -> "C"
  // 평균 < 70 -> "D"
  @Override
  public String getGradeByStudentName(Student[] students, String name) {
    String grade = "";
    for(Student e : students){
      if(e.getName().equals(name)){
        double sum = (getTotalScore(e)) / 3.0;
        if(sum > 90 && sum <= 100)
          grade = "A";

        else if(sum > 80 && sum <= 90)
          grade = "B";

        else if(sum > 70 && sum <= 80)
          grade = "C";

        else
          grade = "D";
      }
    }
    return grade;
  }
}
