package workerAndStudent;

public class PersonInfo {
  private String name;
  private int age;
  private String addr;

  public PersonInfo(String name, int age, String addr) {
    this.name = name;
    this.age = age;
    this.addr = addr;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getAddr() {
    return addr;
  }

  public void setAddr(String addr) {
    this.addr = addr;
  }

  public void displayPersonInfo(){
    System.out.println("이름 : " + name);
    System.out.println("나이 : " + age);
    System.out.println("주소 : " + addr);
  }
}
