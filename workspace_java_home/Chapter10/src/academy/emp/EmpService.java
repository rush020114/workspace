package academy.emp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpService {
  List<Emp> empList;
  Scanner sc;

  public EmpService(){
    sc = new Scanner(System.in);
    empList = new ArrayList<>();
    empList.add(new Emp(1, "김", "개발부", "010-1111", 10000));
    empList.add(new Emp(2, "이", "연두부", "010-2222", 20000));
    empList.add(new Emp(3, "박", "개발부", "010-3333", 30000));
    empList.add(new Emp(4, "최", "홍보부", "010-4444", 40000));
    empList.add(new Emp(5, "홍", "인사부", "010-5555", 50000));
    empList.add(new Emp(6, "정", "개발부", "010-6666", 60000));
    empList.add(new Emp(7, "윤", "순두부", "010-7777", 70000));
    empList.add(new Emp(8, "권", "개발부", "010-8888", 80000));
  }

  // 로그인 기능
  public void login(int empNum, String password){
    for(int i = 0 ; i < empList.size() ; i++){
      if(empList.get(i).getEmpNum() == empNum && empList.get(i).getTel().substring(4).equals(password)){
        System.out.println("로그인 하였습니다.");
        System.out.println(empList.get(i).getName() + "님 반갑습니다.");
        return;
      }
    }
    System.out.println("사번 혹은 비밀번호가 일치하지 않습니다.");
  }

  // 월급 현황
  public void checkSalaryInfo(String dept){
    checkDept(dept);
    showSalary(dept);
  }

  // 월급 인상 후 월급 현황
  public void checkUpSalaryInfo(String dept, int salary){
    checkDept(dept, salary);
    for(int i = 0 ; i < empList.size() ; i++){
      if(empList.get(i).getDept().equals(dept)){
        empList.get(i).setSalary(empList.get(i).getSalary() + salary);
      }
    }
    showSalary(dept);
  }

  // 월급 보여주는 메서드
  public void showSalary(String dept){
    for(Emp emp : empList){
      if(emp.getDept().equals(dept)){
        System.out.println("이름 : " + emp.getName() + " 월급 : " + emp.getSalary());
      }
    }
  }

  // 부서명 입력 메서드
  public String insertDept(){
    System.out.print("부서명 : ");
    return sc.next();
  }

  // 인상 월급 입력 메서드
  public int insertUpSalary(){
    System.out.print("인상급여 : ");
    return sc.nextInt();
  }

  // 부서 확인
  public void checkDept(String dept){
    for(Emp emp : empList){
      if(emp.getDept().equals(dept)){
        System.out.println("==" + emp.getDept() + " 월급 현황==");
        return;
      }
    }
  }

  public void checkDept(String dept, int salary){
    for(Emp emp : empList){
      if(emp.getDept().equals(dept)){
        System.out.println(emp.getDept() + "각 사원의 급여각 각각 " + salary + "원씩 인상됩니다.");
        System.out.println("==월급 인상 후 " + emp.getDept() + " 월급 현황==");
        return;
      }
    }
  }
}
