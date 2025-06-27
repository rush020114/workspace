package 실습;

import java.util.Scanner;

// 학생 관리 기능을 제공하는 클래스
// 학생 등록, 학생 목록 조회, 학생 한 명 조회
public class StuManager {
  // 멤버변수에는 필요한 데이터를 선언만 해놓는다.
  private Stu[] students; // Stu를 담을 수 있는 배열 선언
  private int cnt; // 등록된 학생수
  private Scanner sc;

  // 생성자에는 초기값을 초기화해준다.
  public StuManager(){
    students = new Stu[5]; // 생성자에서 배열 초기화
    cnt = 0;
    sc = new Scanner(System.in);
  }

  // 학생 등록 기능
  public void regStudent(){
    System.out.println("-- 학생 등록을 시작합니다 --");
    // 학생 정보 키보드로 입력
    System.out.print("학번 : ");
    int stuNum = sc.nextInt();
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("국어점수 : ");
    int korScore = sc.nextInt();
    System.out.print("영어점수 : ");
    int engScore = sc.nextInt();

    // 학생 객체 생성
    Stu student = new Stu(stuNum, name, korScore, engScore);


    // 생성한 객체를 배열에 저장
    students[cnt] = student;
    cnt++;
  }

  // 모든 학생의 정보를 출력 기능
  public void printStudentInfoAll(){
    System.out.println("-- 모든 학생 정보는 다음과 같습니다 --");
    for(Stu e : students){
      e.display();
    }
  }

  // 학생 한 명의 정보 출력 기능
  public void printStudentInfo(){
    System.out.println("학생 한 명 정보 출력 기능 실행");
  }

}
