package workerAndStudent;

public class WorkerInfo {
  private String company;
  private String dept;
  private int pay;

  public WorkerInfo(String company, String dept, int pay) {
    this.company = company;
    this.dept = dept;
    this.pay = pay;
  }

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public int getPay() {
    return pay;
  }

  public void setPay(int pay) {
    this.pay = pay;
  }

  public void displayWorkerInfo(){
    System.out.println("회사명 : " + company);
    System.out.println("부서 : " + dept);
    System.out.println("급여 : " + pay);
  }
}
