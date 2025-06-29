package academy;

import java.util.Scanner;

public class StudentProgram {
  public static void main(String[] args){
    StudentManager studentManager = new StudentManager();
    Scanner sc = new Scanner(System.in);
    boolean run = true;

    System.out.println("학생관리 프로그램을 실행합니다.");
    while(run){
      System.out.print("1)학생등록 2)학생정보변경(연락처) 3)학생정보출력 4)모든학생정보출력 5)프로그램 종료 : ");
      int selectNum = sc.nextInt();
      switch(selectNum){
        case 1:
          studentManager.regStudent(); // studentManager를 참조하여 regStudent메서드 실행
          System.out.println();
          break;
        case 2:
          studentManager.changeStudent();
          System.out.println();
          break;
        case 3:
          studentManager.printStudentInfo();
          System.out.println();
          break;
        case 4:
          studentManager.printStudentInfoAll();
          System.out.println();
          break;
        case 5:
        default:
          System.out.println("프로그램을 종료합니다.");
          run = false;
      }
    }
  }
}
