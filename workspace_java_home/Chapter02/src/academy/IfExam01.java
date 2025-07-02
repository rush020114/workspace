import java.util.Scanner;

public class IfExam01 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("학점 비교(단, 0~100)");
    System.out.print("점수 입력 : ");
    int score = sc.nextInt();
    String grade = ""; // 현재의 grade 값은 비어있음

    if (score > 90 && score <= 100) { // score가 91~100이면 grade값을 A로 저장
      grade = "A";
    }

    else if (score > 80) { // score가 90이상이면 if문에서 마무리되므로 조건을 좀 더 편하게 작성
      grade = "B"; // score가 else if의 조건을 충족하면 B로 저장
    }

    else {
      grade = "C";
    }
    // if문 밖에 위치하면 조건에 상관없이 실행하며 grade값만 잘 정해준다면 출력문을 굳이 if문들에 넣을 필요가 없음
    System.out.println("당신의 학점은 " + grade + "입니다.");

  }
}
