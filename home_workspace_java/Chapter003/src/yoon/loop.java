package yoon;

public class loop {
  public static void main(String[] args) {
    // 무한루프 : 무한히 실행할 수 있는 반복문
    // while의 조건문에 true를 넣어주면 된다.
    int num  = 1;
    while(true){
      if(num % 6 == 0 && num % 14 == 0){
        break;
      }
      num++;
    }
    System.out.println("num의 값 : " + num);
  }
}
