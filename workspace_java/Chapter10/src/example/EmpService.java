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
    System.out.print("부서명 : ");
    String dept = sc.next();
    System.out.println("==개발부 월급 현황==");
    int sum = 0;
    int cnt = 0;
    for(int i = 0 ; i < empList.size() ; i++){
      if(empList.get(i).getDept().equals(dept)){
        System.out.println("이름 : " + empList.get(i).getName() + ", 월급 : " + empList.get(i).getPay());
        sum += empList.get(i).getPay();
        cnt++;
      }
    }
    double avg = sum / (double)cnt;
    System.out.println(dept + "서의 월급 총액은 " + sum + "원이며, 평균 급여는 " + avg + "원입니다.");
  }

  // 부서 월급 인상
  public void upPay(){
    System.out.print("부서명 : ");
    String dept = sc.next();
    System.out.print("인상급여 : ");
    int pay = sc.nextInt();
    System.out.println(dept + " 각 사원의 급여가 각각 " + pay + "원씩 인상됩니다.");
    System.out.println("==월급 인상 후 개발부 월급 현황==");
    for(Emp e : empList){
      if(e.getDept().equals(dept)){
        int rePay = e.getPay() + pay;
        e.setPay(rePay);
        System.out.println("이름 : " + e.getName() + " 월급 : " + rePay);
      }
    }

  }
}
