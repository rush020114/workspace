package academy.person;

public class WorkInfo extends PersonInfo{
  private String compName;
  private String dept;
  private int sal;

  public WorkInfo(String name, int age, String addr, String compName, String dept, int sal){
    super(name, age, addr);
    this.compName = compName;
    this.dept = dept;
    this.sal = sal;
  }

  public String toString(){
    return super.toString() + ", 회사명 : " + compName + ", 부서 : " + dept + ", 급여 : " + sal;
  }
}
