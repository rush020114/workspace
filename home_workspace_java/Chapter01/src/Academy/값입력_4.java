import java.util.Scanner;

public class 값입력_4 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in); // 키보드 값을 인식
    int a = sc.nextInt(); // 정수 하나를 입력받아 a에 저장
    System.out.println(a);// 입력받아 저장된 a를 출력

    String name = sc.next(); // 문자열 하나를 입력받아 name에 저장
    System.out.println(name);
  }
}