import java.util.Scanner;

public class IfExam03 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int x, y;
    System.out.println("점 x, y의 좌표를 입력하세요.");
    x = sc.nextInt();
    y = sc.nextInt();
    String exist; // 코드를 간결하게 작성하기 위한 문자열 변수
    if ((x >= 50 && x <= 100) && (y >= 50 && y <= 100) ) { // 사각형 안의 좌표 조건
      exist = "있"; // x좌표가 50~100, y좌표가 50~100이라면 exist는 "있"으로 저장
    }

    else{
      exist = "없"; // 위의 범위를 벗어나면 exist는 "없"으로 저장
    }

    System.out.println("사각형 안에 점이 " + exist + "습니다."); // 좌표 안이면 있습니다 출력, 밖이면 없습니다 출력

    System.out.print("점 a, b의 좌표를 입력하세요.");
    int a = sc.nextInt();
    int b = sc.nextInt();
    System.out.println((a >= 50 && a <= 100) && (b >= 50 && b <= 100) ? "사각형 안" : "사각형 밖");

  }
}
