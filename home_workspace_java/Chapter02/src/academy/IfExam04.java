import java.util.Scanner;

public class IfExam04 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.print("1~99사이의 정수를 입력하세요. : ");
    int num = sc.nextInt();
    int clap = 0;
    int tens = num / 10;
    int ones = num % 10;

    if (tens % 3 == 0 && tens != 0) {
      clap++;
    }

    if (ones % 3 == 0 && ones != 0) {
      clap++;
    }

    switch(clap){
      case 1 :
        System.out.println("박수짝");
        break;
      case 2 :
        System.out.println("박수짝짝");
    }

  }
}
