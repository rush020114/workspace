package academy.school;

import java.util.ArrayList;
import java.util.List;

public class StudyClass {
  private List<Student> students;
  private String className;
  private String teacher;

  public StudyClass(String className, String teacher){
    this.className = className;
    this.teacher = teacher;
    students = new ArrayList<>();
  }

  public void setStudent(String name, int age, int score){
    students.add(new Student(name, age, score));
  }

  public String getTeacher(){
    return teacher;
  }

  public String getClassName(){
    return className;
  }

  // 해당 반의 모든 학생의 모든 정보를 출력하는 기능
  public void printAllStudentsInfo(){
    for(Student student : students){
      System.out.println(student);
    }
  }

  // 해당 반의 평균 성적을 리턴하는 기능
  public double returnClassAvg(){
    int sum = 0;
    for(Student student : students){
      sum += student.getScore();
    }
    return (double)sum / students.size();
  }

  // 해당 반에서 최고 성적을 지닌 학생을 리턴하는 기능
  public Student returnClassHighestScore(){
    int index = 0;
    int max = students.get(0).getScore();
    for(int i = 0 ; i < students.size() ; i++){
      if(max < students.get(i).getScore()){
        index++;
      }
    }
    return students.get(index);
  }

}
