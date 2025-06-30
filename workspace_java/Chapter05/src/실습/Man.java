package 실습;

public class Man {
  String name;
  int age;
  String address;

  public void setManInfo(String newName, int newAge, String newAddress){
    name = newName;
    age = newAge;
    address = newAddress;
  }

  public void setName(String newName){
    name = newName;
  }

  public void setAge(int newAge){
    age = newAge;
  }

  public void setAddress(String newAddress){
    address = newAddress;
  }

  public String returnName(){
    return name;
  }

  public int returnAge(){
    return age;
  }

  public String returnAddress(){
    return address;
  }

  public void printManInfo(){
    System.out.println(name);
    System.out.println(age);
    System.out.println(address);
  }
}
