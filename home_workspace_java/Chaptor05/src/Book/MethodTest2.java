package book;

public class MethodTest2 {
  public static void main(String[] args){
    Student kim = new Student(); // Student 클래스를 참조할 수 있는 참조변수 kim 선언과 생성을 동시에
    kim.printAvg(83, 77, 79); // Student클래스의 printAvg메서드 호출(매개변수 3개를 필요로 하므로 3개를 전달)
    // 전달되는 데이터를 인자라 함.


    kim.forTest();
    kim.printInfo();

    // 지역변수와 함께 리턴할 값을 받아 사용하는 문장.
    int sum = kim.forReturn();
    System.out.println("1 ~ 100까지의 합 : " + sum);


    // 지역변수 없이 바로 return값을 쓰는 문장.
    System.out.println("1 ~ 100까지의 합 : " + kim.forReturn());
    System.out.println(kim.printReturnInfo());
  }
}
