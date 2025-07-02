import java.util.Scanner;

public class 값입력_5 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("먹고 싶은 음식은 ? (3개만 입력 가능) : ");
    String food1 = sc.next(); // 문자열을 입력받겠다는 문장 : food1 변수에 문자열 입력 후 값 저장
    String food2 = sc.next(); // food2 변수에 문자열 입력 후 값 저장
    String food3 = sc.next(); // food3 변수에 문자열 입력 후 값 저장
    System.out.println("[" + food1 + "] 나왔습니다."); // 저장된 food1 변수값 출력
    System.out.println("[" + food2 + "] 나왔습니다."); // 저장된 food2 변수값 출력
    System.out.println("[" + food3 + "] 나왔습니다."); // 저장된 food3 변수값 출력
  }
}
