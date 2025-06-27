import java.util.Scanner;

public class 문제_1_10_1 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num1, num2, num3;
    System.out.print("첫번째 수 : ");
    num1 = sc.nextInt();
    System.out.print("두번째 수 : ");
    num2 = sc.nextInt();
    System.out.print("세번째 수 : ");
    num3 = sc.nextInt();

    int max, mid, min;
    if (num1 > num2 && num1 > num3) { // num1이 제일 크다면 실행시키겠다.
      max = num1;
      mid = num2 > num3 ? num2 : num3; // num2가 num3보다 크다면 num2를 mid에 저장시키겠다.
      min = num2 > num3 ? num3 : num2; // num2가 num3보다 크다면 num3를 min에 저장시키겠다.
    }

    else if(num2 > num1 && num2 > num3){
      max = num2;
      mid = num1 > num3 ? num1 : num3;
      min = num1 > num3 ? num3 : num1;
    }

    else{
      max = num3;
      mid = num1 > num2 ? num1 : num2;
      min = num1 > num2 ? num2 : num1;
    }
    System.out.println(max + " > " + mid + " > " + min);

  }
}
