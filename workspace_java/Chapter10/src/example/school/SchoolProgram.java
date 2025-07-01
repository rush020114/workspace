package example.school;

import java.util.ArrayList;
import java.util.List;

public class SchoolProgram {
  public static void main(String[] args){
    List<Student> studentList1 = new ArrayList<>();
    Student student1 = new Student("김", 20, 90);
    Student student2 = new Student("이", 20, 80);
    Student student3 = new Student("박", 20, 70);
    studentList1.add(student1);
    studentList1.add(student2);
    studentList1.add(student3);
    StudyClass studyClass1 = new StudyClass("A", "kim", studentList1);
    List<Student> studentList2 = new ArrayList<>();
    Student student4 = new Student("최", 20, 95);
    Student student5 = new Student("정", 20, 85);
    Student student6 = new Student("김", 20, 75);
    studentList2.add(student4);
    studentList2.add(student5);
    studentList2.add(student6);
    StudyClass studyClass2 = new StudyClass("B", "kim", studentList2);
    List<Student> studentList3 = new ArrayList<>();
    Student student7 = new Student("홍", 20, 65);
    Student student8 = new Student("이", 20, 100);
    Student student9 = new Student("박", 20, 60);
    studentList3.add(student7);
    studentList3.add(student8);
    studentList3.add(student9);
    StudyClass studyClass3 = new StudyClass("C", "park", studentList3);

    studyClass1.printStudentInfoAll();
    studyClass2.printStudentInfoAll();
    studyClass3.printStudentInfoAll();

    System.out.println(studyClass1.getStudentAvg());
    System.out.println(studyClass2.getStudentAvg());
    System.out.println(studyClass3.getStudentAvg());

    System.out.println(studyClass1.getStudentHighestScore());
    System.out.println(studyClass2.getStudentHighestScore());
    System.out.println(studyClass3.getStudentHighestScore());

    List<StudyClass> studyClassList = new ArrayList<>();
    studyClassList.add(studyClass1);
    studyClassList.add(studyClass2);
    studyClassList.add(studyClass3);
    School school = new School(studyClassList);

    System.out.println("------------------------------------");
    school.teacherOfStudent("kim");
    System.out.println("------------------------------------");
    school.teacherOfStudent("park");
    System.out.println("------------------------------------");
    school.printEachClassScoreAvgAndAllStudentScoreAvg();
    System.out.println("------------------------------------");
    school.firstScoreInSchool();
    System.out.println("------------------------------------");
    System.out.println(school.getClassAvg(studyClass1));
  }
}
