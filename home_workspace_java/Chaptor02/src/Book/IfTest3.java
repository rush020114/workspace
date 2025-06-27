public class IfTest3 {
  public static void main(String[] args){
    int javaScore = 89;

    if (javaScore >= 90) {
      System.out.println(javaScore + "점은 A 등급입니다.");
    }

    else if (javaScore >= 80) { // 90점이 넘으면 if문에서 실행이 되기 때문에 90미만은 적을 필요 없음.
      System.out.println(javaScore + "점은 B 등급입니다.");
    }

     else if (javaScore >= 70) { // 마찬가지로 80점이 넘으면 바로 위의 else if문에서 실행이 되기에 80미만은 적을 필요 없음.
      System.out.println(javaScore + "점은 C 등급입니다.");
    }

     else if (javaScore >= 60) {
      System.out.println(javaScore + "점은 D 등급입니다.");
    }

     else { // 60점 이상이 아니면
      System.out.println(javaScore + "점은 F 등급입니다.");
    }

     //간결한 코드
    int jScore = 75;
    String grade = ""; // 등급을 저장할 문자열을 지금은 비워둠.

    if (jScore >= 90) {
      grade = "A";
    }

    if (jScore >= 80) {
      grade = "B";
    }

    else if (jScore >= 70) {
      grade = "C";
    }

    else if (jScore >= 60) {
      grade = "D";
    }

    else {
      grade = "E";
    }

    // 조건문에 변수만 저장하여 출력문을 전부 쓰는 수고를 덜 수 있었음.
    System.out.println(jScore + "점은 " + grade + " 등급입니다.");

  }
}
