package example.emp;

public class Emp {
  private int empNo;
  private String name;
  private String dept;
  private String tel;
  private int salary;

  public Emp(int empNo, String name, String dept, String tel, int salary) {
    this.empNo = empNo;
    this.name = name;
    this.dept = dept;
    this.tel = tel;
    this.salary = salary;
  }

  public int getEmpNo() {
    return empNo;
  }

  public void setEmpNo(int empNo) {
    this.empNo = empNo;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }
}
