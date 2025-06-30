package student;

import java.util.Scanner;

public class StudentManager {
  private Student[] students;
  private int cnt;
  Scanner sc;
  public StudentManager(){
    students = new Student[3];
    cnt = 0;
    sc = new Scanner(System.in);
  }

  public void regStudent(){
    if(cnt >= 3){
      System.out.println("더 이상 등록할 수 없습니다.");
      return;
    }
    // 키보드로 입력받은 값을 리턴해주면 배열 요소에 넣은 후 cnt를 1 더해주겠다.
    students[cnt++] = createStudent();
  }

  // 학생정보변경(연락처)
  public void changeStudentTel(){
    System.out.println("학생의 연락처를 변경합니다.");
    System.out.print("변경 학생 : ");
    String changeName = sc.next();
    boolean isNotFound = true;
    for(int i = 0 ; i < cnt ; i++){
      if(students[i].getName().equals(changeName)){
        System.out.print("연락처 : ");
        students[i].setTel(sc.next());
        System.out.println("변경완료 되었습니다.");
        isNotFound = false;
        break;
      }
    }
    if(isNotFound){
      System.out.println("이름이 일치하는 학생이 없습니다.");
    }
  }

  // 학생정보출력
  public void printStudentInfo(){
    System.out.print("정보를 열람할 학생 : ");
    String changeName = sc.next();
    boolean isNotFound = true;
    for(int i = 0 ; i < cnt ; i++){
      if(students[i].getName().equals(changeName)){
        System.out.println("요청하신 학생의 정보입니다.");
        System.out.print("이름 : " + students[i].getName());
        System.out.print(" ,나이 : " + students[i].getAge());
        System.out.println(", 연락처 : " + students[i].getTel());
        isNotFound = !isNotFound; // if문이 실행될 때만 false로 바뀌므로 밑의 if문을 빠져나갈 수 있다.
        break;
      }
    }
    if (isNotFound) { // 찾지 못했으면 true이므로 실행
      System.out.println("이름이 일치하는 학생이 없습니다.");
    }
  }

  // 모든학생정보출력
  public void printStudentInfoAll(){
    if(cnt == 0){
      System.out.println("등록된 학생이 없습니다.");
    }
    else{
      System.out.println("모든 학생의 정보입니다. 현재 총 학생 수는 " + cnt + "명입니다.");
      for(int i = 0 ; i < cnt ; i++){
        students[i].display();
      }
    }
  }

  // 키보드로 입력받은 정보를 가진 학생 객체를 생성 후 리턴하는 메서드
  public Student createStudent(){
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
    return student;
  }
}
