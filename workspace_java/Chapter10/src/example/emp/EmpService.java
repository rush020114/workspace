package example.emp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmpService {
  private List<Emp> empList;
  Scanner sc;

  public EmpService(){
    sc = new Scanner(System.in);
    empList = new ArrayList<>(); // EmpService 생성 시 Emp 클래스가 Emp 리스트에 저장됨
    empList.add(new Emp(1001, "김자바", "개발부", "010-1111-1111", 5000));
    empList.add(new Emp(1002, "이자바", "영업부", "010-1111-2222", 6000));
    empList.add(new Emp(1003, "홍자바", "개발부", "010-1111-3333", 7000));
    empList.add(new Emp(1004, "박자바", "영업부", "010-1111-4444", 8000));
    empList.add(new Emp(1005, "정자바", "인사부", "010-1111-5555", 9000));
  }

  // 메서드의 return의 역할
  // 1. 메서드의 결과 데이터를 반환(리턴)
  // 2. 메서드 안의 리턴을 return;으로 사용하면  메서드를 종료
  // login 메서드
  public void login(){
    while(true){
      System.out.print("사번 : ");
      int empNum = sc.nextInt();
      System.out.print("비밀번호(연락처 마지막 4자리) : ");
      String tel = sc.next();
      for(int i = 0 ; i < empList.size() ; i++){
        // 어떤 메서드를 사용할 수 있는지는 .을 찍기 전 자료형을 잘 확인해야 한다.
        //                                      여기는 Emp    여기는 String 여기도 String
        if(empList.get(i).getEmpNo() == empNum && empList.get(i).getTel().substring(9).equals(tel)){
          System.out.println("로그인 하였습니다.");
          System.out.println(empList.get(i).getName() + "님 반갑습니다.");
          return;
        }
      }
      System.out.println("사번 혹은 비밀번호가 일치하지 않습니다.");
    }
  }

  public void printSalaryInfo(){
    System.out.print("부서명 : ");
    String deptName = sc.next();
    System.out.println("==" + deptName + " 월급 현황==");
    int salarySum = 0;
    int cnt = 0;
    for(int i = 0 ; i < empList.size() ; i++){
      if(empList.get(i).getDept().equals(deptName)){
        System.out.println("이름 : " + empList.get(i).getName());
        System.out.println("월급 : " + empList.get(i).getSalary());
        salarySum += empList.get(i).getSalary();
        cnt++;
      }
    }
    double avg = salarySum / (double)cnt;
    System.out.println(deptName + "서의 월급 총액은 " + salarySum + "원이며, 평균은 " + avg + "입니다.");
  }

  public void updateSalary(){
    System.out.print("부서명 : ");
    String deptName = sc.next();
    System.out.print("인상급여 : ");
    int money = sc.nextInt();
    System.out.println(money + "원 인상합니다.");
    for(int i = 0 ; i < empList.size() ; i++){
      if(empList.get(i).getDept().equals(deptName)){
        int repay = empList.get(i).getSalary() + money;
        empList.get(i).setSalary(repay);

        System.out.println("이름 : " + empList.get(i).getName() + ", 월급 : " + empList.get(i).getSalary());
      }
    }
  }
}
