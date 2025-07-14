package academy.person;

public class PersonInfo {
  private String name;
  private int age;
  private String addr;

  public PersonInfo(String name, int age, String addr){
    this.name = name;
    this.age = age;
    this.addr = addr;
  }



  public String toString(){
    return "이름: " + name + ", 나이 : " + age + ", 주소 : " + addr;
  }
}
