package example;

public class MyStudentTest {
  public static void main(String[] args) {
    MyStudent myStudent = new MyStudent();
    Student[] students = new Student[5];
    students[0] = new Student("이", 90, 87, 95);
    students[1] = new Student("김", 70, 84, 81);
    students[2] = new Student("박", 61, 67, 73);
    students[3] = new Student("최", 90, 87, 85);
    students[4] = new Student("정", 100, 97, 75);

    System.out.println("학생 한명의 총점 : " + myStudent.getTotalScore(students[0]));
    System.out.println("두 학생 중 점수가 더 높은 학생 : " + myStudent.getHighScoreStudent(students[3], students[1]).getName());
    System.out.println("학생의 등급 : " + myStudent.getGradeByStudentName(students, students[1].getName()));
  }
}
