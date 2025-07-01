package example.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudyClass {
  Scanner sc;
  private String className;
  private String teacher;
  private List<Student> studentList;
  private Student student;

  public StudyClass(String className, String teacher, Student student){ // 생성자 : 객체 생성 시 멤버변수를 초기화하며 기능을 실행.
    sc = new Scanner(System.in);
    studentList = new ArrayList<>();
    this.className = className;
    this.teacher = teacher;
  }

  public List<Student> getStudentList() {
    return studentList;
  }

  public void setStudentList(List<Student> studentList) {
    this.studentList = studentList;
  }

  public String getClassName() {
    return className;
  }

  public void setClassName(String className) {
    this.className = className;
  }

  public String getTeacher() {
    return teacher;
  }

  public void setTeacher(String teacher) {
    this.teacher = teacher;
  }

  // 해당 반의 모든 학생의 모든 정보를 출력하는 기능
  public void printStudentInfoAll(){
    for(Student student : studentList){
      System.out.println(student);
    }
  }

  // 해당 반의 평균 성적을 리턴하는 기능
  public double getStudentAvg(){
    int sum = 0;
    for(Student student : studentList){
      sum += student.getScore();
    }
    double avg = (double)(sum) / studentList.size();
    return avg;
  }

  // 해당 반에서 최고 성적을 지닌 학생을 리턴하는 기능
  public Student getStudentHighestScore(){
    int max = studentList.get(0).getScore();
    int index = 0;
    for(Student student : studentList){
      if(max < student.getScore()){
         index++;
      }
    }
    return studentList.get(index);
  }

}
