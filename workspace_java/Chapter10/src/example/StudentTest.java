package example;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {
  public static void main(String[] args){
    List<Student> studentList = new ArrayList();

    studentList.add(new Student("kim", 90, 85, 95));
    studentList.add(new Student("lee", 80, 80, 95));
    studentList.add(new Student("park", 20, 55, 70));

    System.out.println(studentList);

    for(Student e : studentList){
      if(e.getSumScore() > 150){
        System.out.println(e);
      }
    }

    int sum = 0;
    for(Student e : studentList){
      sum += e.getSumScore();
    }
    System.out.println(sum / (double)(studentList.size()));

    int max = studentList.get(0).getSumScore();

    int man = 0;
    for(int i = 0 ; i < studentList.size() ; i++){
      if(max < studentList.get(i).getSumScore()){
        max = studentList.get(i).getSumScore();
        man = i;
      }
    }
    System.out.println(studentList.get(man));
  }
}
