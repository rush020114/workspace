package example.school;

import java.util.ArrayList;
import java.util.List;

public class SchoolProgram {
  public static void main(String[] args){
    Student student1 = new Student("kim", 20, 70); // Student 클래스 객체 생성 student1은 이 객체를 참조한다.
    Student student2 = new Student("lee", 20, 80);
    Student student3 = new Student("park", 20, 90);
    Student student4 = new Student("choi", 20, 95);
    Student student5 = new Student("jung", 20, 85);
    Student student6 = new Student("hong", 20, 75);
    Student student7 = new Student("kim", 20, 100);
    Student student8 = new Student("lee", 20, 60);
    Student student9 = new Student("park", 20, 65);
    List<Student> studentList1 = new ArrayList<>(); // Student를 담을 수 있는 list 만들기.
    studentList1.add(student1); // Student를 담을 수 있는 list에 student객체를 담는 문법.
    studentList1.add(student2);
    studentList1.add(student3);
    List<Student> studentList2 = new ArrayList<>(); // Student를 담을 수 있는 list 만들기.
    studentList2.add(student4);
    studentList2.add(student5);
    studentList2.add(student6);
    List<Student> studentList3 = new ArrayList<>(); // Student를 담을 수 있는 list 만들기.
    studentList3.add(student7);
    studentList3.add(student8);
    studentList3.add(student9);

    StudyClass studyClass1 = new StudyClass("A", "김", student1); // 교실이름과 담임이름과 학생 정보를 담은 반 클래스 객체 생성
    StudyClass studyClass2 = new StudyClass("B", "이", student2);
    StudyClass studyClass3 = new StudyClass("C", "박", student3);
    studyClass1.setStudentList(studentList1); //
    studyClass2.setStudentList(studentList2);
    studyClass3.setStudentList(studentList3);
    List<StudyClass> studyClassList = new ArrayList<>();
    studyClassList.add(studyClass1);
    studyClassList.add(studyClass2);
    studyClassList.add(studyClass3);

    for(int i = 0 ; i < studentList1.size() ; i++){
      System.out.println(studyClass1.getStudentList().get(i));
    }

    System.out.println(studyClass2.getStudentAvg());

    System.out.println(studyClass3.getStudentHighestScore());




  }
}
