package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpService {
  Scanner sc = new Scanner(System.in);
  List<Emp> empList;

  public EmpService(){
    empList = new ArrayList<>();
  }

  // 사원 등록 메서드
  public void regEmp(){
    System.out.print("사번 : ");
    int empNum = sc.nextInt();
    System.out.print("이름 : ");
    String name = sc.next();
    System.out.print("부서명 : ");
    String dept = sc.next();
    System.out.print("연락처 : ");
    String tel = sc.next();
    System.out.print("월급 : ");
    int pay = sc.nextInt();
    empList.add(new Emp(empNum, name, dept, tel, pay));
  }

  // 로그인 메서드
  public void login(){
    System.out.print("사번 : ");
    int empNum = sc.nextInt();
    System.out.print("비밀번호 : ");
    String tel = sc.next();
    boolean isNotFound = true;
    for(int i = 0 ; i < empList.size() ; i++){
      if(empList.get(i).getEmpNum() == empNum && empList.get(i).getTel().equals(tel)){
        System.out.println("로그인 하셨습니다.");
        System.out.println(empList.get(i).getName() + "님 반갑습니다.");
        isNotFound = !isNotFound;
        break;
      }
    }
    if(isNotFound){
      System.out.println("사번혹은 비밀번호가 일치하지 않습니다.");
    }
  }

  // 월급 정보 출력
  public void printPay(){
    for(int i = 0 ; i < empList.size() ; i++){
    }
  }
}
