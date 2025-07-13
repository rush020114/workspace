package academy.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager {
  Scanner sc;
  List<Student> students;

  public StudentManager(){
    sc = new Scanner(System.in);
    students = new ArrayList<>();
  }

  // 학생 등록
  public void regiStudent(){
    System.out.print("학생 이름 : ");
    String name = sc.next();
    System.out.print("점수 : ");
    int score = sc.nextInt();
    students.add(new Student(name, score));
  }

  // 성적 산출
  public void showGrade(){
    for(Student student : students){
      System.out.println(student.getScore() >= 90 ? student + ", 등급 : 우수" :  student + ", 등급 : 일반");
    }
  }
}
