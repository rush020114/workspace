import java.util.Scanner;

public class 문제_3_3 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("1~99 사이의 정수를 입력하세요. : ");
    int num = sc.nextInt();
    int clapCnt = 0;
    // 입력받은 수를 십의자리의 수와 일의자리의 수로 분리
    int tens = num / 10; // 10의 자리 구하기
    int ones = num % 10; // 1의 자리 구하기

    // 십의 자리의 숫자가 3, 6, 9라면...
    //if (tens == 3 || tens == 6 || tens == 9) <- 바로 밑의 조건과 같은 뜻
    if (tens % 3 == 0 && tens != 0) {
      clapCnt++;
    }

    // 일의 자리의 숫자가 3, 6, 9라면...
    // 위의 if조건문과 쌍을 이루면 이 조건은 읽히지 않을 때도 있으므로 별도의 if문을 사용
    if (ones % 3 == 0 && tens != 0) {
      clapCnt++;
    }

    // clapCnt가 0~2의 값을 가짐
    switch(clapCnt){
      case 1:
        System.out.println("박수짝");
        break;
      case 2:
        System.out.println("박수짝짝");
        break;

    }
  }
}
