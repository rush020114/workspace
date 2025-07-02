package yoon;

public class Switchbreak {
  public static void main(String[] args) {
    int n = 3;

    // break가 있으면 switch문을 아예 빠져나와 버린다.
    switch(n){
      case 1 :
        System.out.println("Simple Java");
        break;
      case 2 :
      System.out.println("Funny Java");
        break;
      case 3 :
      System.out.println("Fantastic Java");
        break;
      default :
      System.out.println("The best programming language");
    }
    System.out.println("Do you like Java?");

    // switch문의 다른 구성
    // case 1, case 2, case 3의 모든 경우에 있어서 case 3 경우에 있는 문장을 실행시켜도 무방할 경우에 사용
    int m = 3;
    switch(m){
      case 1 :
      case 2 :
      case 3 :
        System.out.println("case 1, 2, 3");
        break;
      default :
        System.out.println("default");
    }
  }
}
