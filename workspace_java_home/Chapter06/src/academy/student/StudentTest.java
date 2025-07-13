package academy.student;

import java.util.Scanner;

public class StudentTest {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    StudentManager studentManager = new StudentManager();
    boolean isRunning = true;

    while(isRunning){
      System.out.print("1.학생등록 2.학생 정보와 등급 3.종료 : ");
      int selectNo = sc.nextInt();

      switch(selectNo){
        case 1:
          studentManager.regiStudent();
          break;
        case 2:
          studentManager.showGrade();
          break;
        case 3:
        default:
          isRunning = !isRunning;
      }
    }
  }
}
