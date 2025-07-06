package academy.school;

import java.util.Scanner;

public class SchoolTest {
  public static void main(String[] args){
    System.out.println("교실, 반 등록 프로그램");
    School school = new School();
    Scanner sc = new Scanner(System.in);
    boolean isRunning = true;

    while(isRunning){
      System.out.print("1.학생등록 2.담당교사 반의 학생 정보 조회 3.반평균과 전체 평균 조회 4.전교 1등 조회 5.해당 반 평균 조회 : ");
      int selectNo = sc.nextInt();
      switch(selectNo){
        case 1:
          school.regStudent();
          break;
        case 2:
          System.out.print("담당교사명 : ");
          String teacher = sc.next();
          school.teacherOfClassInfo(teacher);
          break;
        case 3:
          school.printEachClassAvgAndAllClassAvg();
          break;
        case 4:
          school.printAllClassHighScore();
          break;
        case 5:
          System.out.print("조회할 반 : ");
          String className = sc.next();
          school.printClassAvg(className);
          break;
        default:
          System.out.println("프로그램을 종료합니다.");
          isRunning = !isRunning;
      }
    }
  }
}
