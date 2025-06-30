package 이론;

public class 메서드_5 {
  // 리턴 : 실행 결과를 되돌려준다.
  public static void main(String[] args){
    String name = getName();
    System.out.println(name);
    System.out.println(getName()); // 위의 코드를 한 줄로 줄인 것
    int age = getAge();
    System.out.println(age);
    System.out.println(getAge());
  }

  // 이름을 리턴하는 메서드
  public static String getName(){ // 출력을 위한 메서드라 기능구현에 필요한 데이터는 필요없음
    return "홍길동"; // 홍길동 문자열을 우리에게 되돌려준다.(실행 결과 데이터)
  }

  // 나이를 리턴하는 메서드
  public static int getAge(){
    return 20;
  }
}
