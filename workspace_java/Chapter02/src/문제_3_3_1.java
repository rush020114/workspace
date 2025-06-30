import java.util.Scanner;

public class 문제_3_3_1 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // 일의 자리 정수와 십의 자리 구분할 변수 만들기
    // 박수횟수를 0으로 초기화
    // 십의 자리 숫자가 3, 6, 9이면 박수횟수 1증가
    // 일의 자리 숫자가 3, 6, 9이면 박수횟수 1증가
    // 박수횟수에 따른 실행문 만들기(값이 정해져 있으므로 switch가 적당)
    System.out.print("1~99사이의 정수를 입력해주세요. : ");
    int num = sc.nextInt();

    int clapCnt = 0; // 박수횟수

    // 일의 자리와 십의 자리 분리
    int tens = num / 10; // 1~100 사이의 수를 10으로 나누면 정수가 나오므로 10의 자리 숫자를 나타냄
    int ones = num % 10; // 10으로 나눈 나머지는 일의 자리 수를 나타냄

    if (tens % 3 == 0 && tens != 0) { // 십의 자리에 대한 변수가 3의 배수이지만 0은 아님
      clapCnt++;
    }

    if (ones % 3 == 0 && ones != 0) { // 일의 자리에 대한 변수가 3의 배수이지만 0은 아님
      clapCnt++;
    }

    switch(clapCnt){
      case 1 :
        System.out.println("박수짝");
        break;
      case 2 :
        System.out.println("박수짝짝");
        break;

    }
  }
}
