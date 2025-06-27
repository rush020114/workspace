import java.util.Scanner;

public class 삼항연산자_연습2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("첫번째 수 : ");
    int a = sc.nextInt();
    System.out.print("첫번째 수 : ");
    int b = sc.nextInt();
    // a가 b보다 크면 두 번째 피연산자 출력 그렇지 않으면 세 번째 피연산자 출력
    System.out.println(a > b ? a + " > " + b : b + " > " + a);

    //------------------------------
    System.out.print("첫번째 수 : ");
    int c = sc.nextInt();
    System.out.print("첫번째 수 : ");
    int d = sc.nextInt();

    int max = c > d ? c : d; // c가 d보다 크면 c를 max에 넣겠다.
    int min = c <= d ? c : d; // c가 d보다 작거나 같으면 min에 c를 넣겠다.
    System.out.println(max + " > " + min);
  }
}
