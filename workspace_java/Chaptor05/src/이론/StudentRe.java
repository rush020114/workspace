package 이론;

// 멤버변수 각각의 값을 변경하는 메서드 -> setter라고 부름!
// setter는 메서드 이름이 정해져 있음. set변수명으로 메서드명 정해져있음!
// 멤버변수 각각의 값을 리턴하는 메서드 -> getter라고 부름!
// getter는 메서드 이름이 정해져 있음. get변수명으로 메서드명 정해져있음!
public class StudentRe {
  String name;
  int age;
  String addr;
  String stuNum;
  String tel;

  public void setStudent(String name, int age, String addr, String stuNum, String tel){
    this.name = name;
    this.age = age;
    this.addr = addr;
    this.stuNum = stuNum;
    this.tel = tel;
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

  public String getStuNum() {
    return stuNum;
  }

  public void setStuNum(String stuNum) {
    this.stuNum = stuNum;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }
}
