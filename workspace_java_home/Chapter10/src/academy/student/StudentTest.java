package academy.student;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
  public static void main(String[] args){
    List<Student> studentList = new ArrayList<>();
    studentList.add(new Student("김", 50, 90));
    studentList.add(new Student("이", 60, 100));
    studentList.add(new Student("박", 60, 70));

    int totalAvg = 0;
    for(Student student : studentList){
      System.out.println(student);
      totalAvg += student.getTotalScore();
    }
    for(int i = 0 ; i < studentList.size() ; i++){
      if(studentList.get(i).getTotalScore() >= 150){
        System.out.println(studentList.get(i));
      }
    }

    System.out.println("전체학생 평균 : " + totalAvg / 3.0);

    int index = 0;
    int max = studentList.get(0).getTotalScore();
    for(int i = 0 ; i < studentList.size() ; i++){
      if(max < studentList.get(i).getTotalScore()){
        max = studentList.get(i).getTotalScore();
        index = i;
      }
    }
    System.out.println("총점이 1등인 학생의 정보입니다");
    System.out.println(studentList.get(index));
  }
}
