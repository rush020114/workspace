public class IfTest1 {
  public static void main(String[] args){
    int javaScore = 89;

    if (javaScore >= 60) { // javaScore가 60이상이면 수행문을 실행하겠다.
      System.out.println("합격입니다."); // 합격이므로 수행문 실행
    }

    if (javaScore >= 60) { // if문 안에 if문을 중첩시킬 수 있다.
      if (javaScore>= 80) { // 60점 이상이면서 80이상이므로 수행문 실행
        System.out.print("고득점으로 "); // 만약 변수가 70점이면 "합격입니다." 출력
      }
      System.out.println("합격입니다.");
    }
  }
}
