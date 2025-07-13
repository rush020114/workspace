package academy.student1;

import java.util.Scanner;

public class SchoolTest {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("학생관리 프로그램");
    School1 school = new School1();
    boolean isRunning = true;

    while(isRunning){
      System.out.print("1.교실 및 학생 3명 등록 2.담당교사가 맡는 학생들 3.반 및 학급 평균 4.전교 1등 5.해당 반의 평균 6.종료 : ");
      int selectNo = sc.nextInt();

      switch(selectNo){
        case 1:
          school.regiClassStudy();
          break;
        case 2:
          System.out.print("교사명 : ");
          String teacher = sc.next();
          school.printStudentInfoTeacherOfStudyClass(teacher);
          break;
        case 3:
          school.printEachStudyClassAvgAndAllStudyClassAvg();
          break;
        case 4:
          school.printHighestScoreOfSchool();
          break;
        case 5:
          System.out.print("학급이름 : ");
          String className = sc.next();
          school.getStudyClassAvgInsertClassName(className);
          break;
        case 6:
        default:
          isRunning = !isRunning;
      }
    }
  }
}
