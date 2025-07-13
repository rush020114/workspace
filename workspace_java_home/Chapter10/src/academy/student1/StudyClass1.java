package academy.student1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudyClass1 {
  Scanner sc;
  private List<Student1> student1List;
  private String className;
  private String teacher;

  public StudyClass1(String className, String teacher){
    sc = new Scanner(System.in);
    student1List = new ArrayList<>();
    this.className = className;
    this.teacher = teacher;
    for(int i = 0 ; i < 3 ; i++){
      regiStudent();
    }
  }

  public String getClassName(){
    return className;
  }

  public String getTeacher(){
    return teacher;
  }

  // 학생 등록
  public void regiStudent(){
    System.out.println("학생을 추가합니다.");
    student1List.add(insertStudentInfo());
  }

  // 해당 반의 모든 학생의 모든 정보 출력
  public void printStudentInfoOfStudyClass(){
    for(Student1 student : student1List){
      System.out.println(student);
    }
  }

  // 해당 반의 평균 성적을 리턴
  public double getAvgStudyClass(){
    return studentTotalScore() / student1List.size();
  }

  // 해당 반에서 최고 성적을 지닌 학생 리턴
  public Student1 getHighestScoreOfStudyClass(){
    int max = student1List.get(0).getScore();
    int index = 0;
    for(int i = 0 ; i < student1List.size() ; i++){
      if(max < student1List.get(i).getScore()){
        max = student1List.get(i).getScore();
        index = i;
      }
    }
    return student1List.get(index);
  }

  // 이름, 나이, 점수 입력
  public Student1 insertStudentInfo(){
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("나이 : ");
    int age = sc.nextInt();
    System.out.print("점수 : ");
    int score = sc.nextInt();
    return new Student1(name, age, score);
  }

  // 학생 성적 총합
  public double studentTotalScore(){
    int sum = 0;
    for(Student1 student : student1List){
      sum += student.getScore();
    }
    return sum;
  }
}
