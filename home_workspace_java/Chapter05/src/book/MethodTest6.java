package book;

public class MethodTest6 {
  public static void main(String[] args){
    Student kim = new Student();



    kim.firstScore = 99;
    kim.secondScore = 33;

    System.out.println("before(kim.firstScore) : " + kim.firstScore);
    System.out.println("before(kim.secondScore) : " + kim.secondScore);

    // main메서드에서 swapScore메서드를 호출할 때 kim의 주소값이 swap메서드의 매개변수에 할당된다.
    swapScore(kim);

    System.out.println("after(kim.firstScore) : " + kim.firstScore);
    System.out.println("after(kim.secondScore) : " + kim.secondScore);
  }

  private static void swapScore(Student std){ // Student클래스를 참조하는 kim을 매개변수로 전달하여 두 변수가 Student클래스를 공유하고 있다.
    int temp = std.firstScore;
    std.firstScore = std.secondScore;
    std.secondScore = temp; // 메서드 기능이 이 문장까지 도달하면 Student클래스의 변수가 바뀌어 kim이 참조할 때 영향을 미친다.
    System.out.println(std.firstScore);
    System.out.println(std.secondScore);
  }
}
