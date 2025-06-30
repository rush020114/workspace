package 이론;

public class Worker {
  private String company;
  private String dept;
  private Person personInfo;

  public Worker(String company, String dept, Person personInfo) {
    this.company = company;
    this.dept = dept;
    this.personInfo = personInfo;
  }

  public void setPersonInfo(Person personInfo){
    this.personInfo = personInfo;
  }

  public Person getPersonInfo(){
    return personInfo;
  }

  public void printWorker(){
    System.out.println("회사명 : " + company);
    System.out.println("부서명 : " + dept);
    personInfo.printPersonInfo();
  }
}
