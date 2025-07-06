package book.Inheritance3;

public class Student {
  String name;


  public Student(String name){
    this.name = name;
    System.out.println("===> Student(String name) 생성자 호출");
  }

  String printInfo(){
    return "학생 이름 : " + name;
  }
}
