public class Switch {
  public static void main(String[] args){
    int n = 3;

    // switch문은 어떤 값을 찾았으면 그 경우에서 아래의 결과까지 코드를 계속 실행한다.
    switch(n){
      case 1 :
        System.out.println("Simple Java");
      case 2 :
        System.out.println("Funny Java");
      case 3 :
        System.out.println("Fantastic Java");
      default :
        System.out.println("The best programming language");
    }
    System.out.println("Do you like Java?");
  }
}
