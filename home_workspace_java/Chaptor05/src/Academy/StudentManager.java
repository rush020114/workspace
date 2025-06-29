package academy;

import java.util.Scanner;

// 클래스는 자료형이다. 그리고 사용자 정의 자료형이라 서로 다른 자료형을 보관할 수 있다.
public class StudentManager {
  private Student[] students; // 학생들에 대한 정보들을 관리하기 위한 배열(Student 클래스를 저장할 수 있음) 선언.
  int cnt;
  Scanner sc;

  public StudentManager(){
    students = new Student[3];
    cnt = 0;
    sc = new Scanner(System.in);
  }

  // 학생 등록
  public void regStudent(){
    if(cnt == 3){
      System.out.println("더 이상 학생을 등록할 수 없습니다.");
     return; // return을 사용하여 배열 이상의 학생을 등록하려 할 때 메서드를 종료시켜 오류를 없앰.
    }
      System.out.println("학생 등록을 시작합니다. 학생 정보를 입력하세요.");
      System.out.print("이름 : ");
      String name = sc.next();
      System.out.print("나이 : ");
      int age = sc.nextInt();
      System.out.print("연락처 : ");
      String tel = sc.next();
      System.out.print("학점 : ");
      String grade = sc.next();
      Student student = new Student(name, age, tel, grade);
      students[cnt] = student; // 각각의 students[cnt]가 실행할 때마다 초기화되는 student객체를 참조히도록 설계
      cnt++;
  }

  // 학생 정보 변경
  public void changeStudent(){
    System.out.println("학생의 연락처를 변경합니다.");
    System.out.print("변경 학생 : ");
    String name = sc.next();
    for(int i = 0 ; i < cnt ; i++){ // 적어도 한 요소라도 같은지 확인하기 위해 현 클래스의 cnt만큼 반복문 돌리기 (regStudent 클래스가 실행된 만큼)
      if(name.equals(students[i].getName())){ // 입력한 이름이 Student배열을 하나씩 돌리던 중 찾은 요소에 있는 이름과 같다면
        System.out.print("연락처 : ");
        students[i].setTel(sc.next()); // 같다면 그 요소의 연락처를 새로 바꾸겠다.
        System.out.println("연락처가 변경되었습니다.");
      }
    }
  }

  // 학생 정보 출력
  public void printStudentInfo(){
    System.out.print("정보를 열람할 학생 : ");
    String name = sc.next();
    for(int i = 0 ; i < cnt ; i++){ // 마찬가지로 정보를 열람할 학생을 찾기 위해 적어도 한 요소라도 겹치게 하기 위한 반복문
      if(name.equals(students[i].getName())){
        students[i].display();
      }
    }
  }

  // 모든 학생 정보 출력
  public void printStudentInfoAll(){
    System.out.println("모든 학생의 정보입니다. 현재 총 학생 수는 " + cnt + "명입니다.");
    for(int i = 0 ; i < cnt ; i++){
      students[i].displayAll();
    }
  }

}


