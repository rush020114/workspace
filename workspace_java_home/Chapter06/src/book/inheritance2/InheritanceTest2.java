package book.inheritance2;

public class InheritanceTest2 {
  public static void main(String[] args){
    UniversityStudent kim = new UniversityStudent();
    kim.name = "김둘리";
    kim.score = 83;
    kim.major = "컴퓨터 공학";

    kim.printInfo();
  }
}
