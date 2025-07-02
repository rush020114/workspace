public class VariableTest2 {
  public static void main(String[] args){
    // 기본자료형
    // 논리 타입
    boolean isPassed = true; // 논리타입은 true, false 형태의 값을 가짐
    System.out.println(isPassed); // 논리 타입의 값은 소문자로 작성

    // 문자 타입
    char grade = 'A'; // 문자타입은 한 글자만 오며 작은따옴표로만 감싸야 한다.
    System.out.println("등급 : " + grade); // 문자열과 문자가 만나 문자열로 형변환됨
    String numgrade = "B"; // String 타입은 기본자료형이 아니며 문자열(여러 개의 문자)을 저장한다.
    System.out.println(numgrade);

    // 정수 타입
    byte year = 3;
    short score = 17;
    int javaScore = 83; // 자바에서 리터럴 형태의 정수는 int타입이다.
    long currentTime = 123456789L; // long으로 변환하기 위해선 L을 뒤에 입력한다.
    System.out.println(year);
    System.out.println(score);
    System.out.println("점수 = " + javaScore);
    System.out.println(currentTime);

    // 실수 타입
    float javaAvg = 78.25F; // float로 변환하기 위해선 f나 F를 뒤에 입력한다.
    double examAvg = 76.234522; // java 자바에서 리터럴 형태의 실수는 double타입이다.
    System.out.println(javaAvg);
    System.out.println(examAvg);
  }
}
