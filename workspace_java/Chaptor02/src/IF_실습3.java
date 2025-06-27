import java.util.Scanner;

public class IF_실습3 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("1번");
    int a, b, c;

    System.out.print("첫번째 변 : ");
    a = sc.nextInt();
    System.out.print("두번째 변 : ");
    b = sc.nextInt();
    System.out.print("세번째 변 : ");
    c = sc.nextInt();

    if (a < b + c && b < c + a && c < a + b) {
      System.out.println("삼각형");
    }

    else{
      System.out.println("삼각형 안됨");
    }

    System.out.println("2번");

    int x, y;
    System.out.println("점 x, y의 좌표를 입력하시오.");
    x = sc.nextInt();
    y = sc.nextInt();
    String border = "";

    if (((x >= 50) && (x <= 100)) && ((y >= 50) && (y <= 100))) {
      border = "안";
    }

    else{
      border = "밖";
    }
    System.out.println("범위 " + border);

    System.out.println("3번");
    int num;
    System.out.print("정수를 입력하세요. : ");
    num = sc.nextInt();

    if (((num % 10 == 3) || (num % 10 == 6) || (num % 10 == 9)) && (num % 3 == 0) && (num >= 10)) {
      System.out.println("박수짝짝");
    }

    else if(((num % 10 == 3) || (num % 10 == 6) || (num % 10 == 9)) || (num % 30 == 0)){
      System.out.println("박수짝");
    }

  }
}

