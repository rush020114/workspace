public class IfTest2 {
  public static void main(String[] args){
    int javaScore = 25;
    if (javaScore >= 60) { // javaScore가 60점 이상이면
      System.out.println(javaScore + "점은 합격입니다.");
    }

    // 60점 미만이면서 30점 미만인 사람에겐 패널티를 부여할 수 있는 문장
    else{ // javaScore가 60점 이상이 아니면
      if (javaScore <= 30) { // javaScore가 60점 이상이 아니면서 30점 이하이면
        System.out.println(javaScore + "점은 패널티 대상입니다.");
      }
      else { // javaScore가 60점 이상이 아니면서 30점 이하가 아니면(점수가 31~59이면)
        System.out.println(javaScore + "점은 불합격입니다.");
      }

    }
  }
}
