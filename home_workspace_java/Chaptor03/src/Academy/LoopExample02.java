import java.util.Scanner;

public class LoopExample02 {
  public static void main(String[] args) {
    // 두 정수 사이의 값을 더하는 문제
    // while
    Scanner sc = new Scanner(System.in);
    int num1 = sc.nextByte();
    int num2 = sc.nextByte();
    int max = num1 > num2 ? num1 : num2;
    int min = num1 > num2 ? num2 : num1;
    int sum = 0;
    int a = min + 1; // 최솟값을 포함하지 않기 위해 1을 더하고 반복문을 시작
    while(max > a){ // 최솟값보다 1큰 수가 최댓값보다 작을 때까지 반복
      sum = sum + a; // 최솟값보다 1큰 수를  최댓값보다 작은 수까지 누적해서 덧셈하는 식
      a++; // 반복문 파기를 위한 i연산식
    }
    System.out.println(sum);

    // for
    int i = sc.nextInt();
    int j = sc.nextInt();
    int summary = 0;
    // i값과 j값의 대소를 정하기 위해 for문을 두 개 사용
    // 위의 for문은 i의 값이 작은 경우, 밑의 for문의 j의 값이 작은 경우
    for(int x = i + 1 ; x < j ; x++){ // 입력받을 값을 포함하지 않기 위해 1을 더한 후 큰 수보다 작을 때까지 1증가하면서 반복
      summary = summary + x;
    }
    for(int y = j + 1 ; y < i ; y++){
      summary = summary + y;
    }
    System.out.println(summary);
  }
}
