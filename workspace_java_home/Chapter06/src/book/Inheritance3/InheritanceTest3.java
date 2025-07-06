package book.Inheritance3;

public class InheritanceTest3 {
  public static void main(String[] args){
    UniversityStudent kim = new UniversityStudent("김둘리", 83);
    System.out.println(kim.name + "의 점수 : " + kim.score);
    System.out.println(kim.printInfo());

  }
}
