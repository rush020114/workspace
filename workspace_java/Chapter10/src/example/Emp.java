package example;

public class Emp {
  private int empNum;
  private String name;
  private String dept;
  private String tel;
  private int pay;

  public Emp(int empNum, String name, String dept, String tel, int pay) {
    this.empNum = empNum;
    this.name = name;
    this.dept = dept;
    this.tel = tel;
    this.pay = pay;
  }

  public int getEmpNum() {
    return empNum;
  }

  public void setEmpNum(int empNum) {
    this.empNum = empNum;
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

  public int getPay() {
    return pay;
  }

  public void setPay(int pay) {
    this.pay = pay;
  }
}
