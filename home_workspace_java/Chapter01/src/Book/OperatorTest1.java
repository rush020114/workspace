public class OperatorTest1 {
  public static void main(String[] args){
    // 연산자
    int javaScore = 83;
    int pythonScore = 100;

    System.out.println(javaScore + pythonScore); // 두 변수를 더한 값 출력
    System.out.println("두 시험 점수의 합 : " + javaScore + pythonScore); // 문자열과 정수의 연산이므로 문자열로 변함.
    System.out.println("두 시험 점수의 합 : " + "83" + pythonScore); // 1차 반환
    System.out.println("두 시험 점수의 합 : 83" + "100"); // 2차 반환
    System.out.println("두 시험 점수의 합 : 83100"); // 최종 결과
    System.out.println("두 시험 점수의 합 : " + (javaScore + pythonScore)); // 괄호로 우선순위를 지정하면 해결할 수 있다.
    System.out.println("- 연산 결과 : " + (javaScore - pythonScore)); // 뺄셈
    System.out.println("* 연산 결과 : " + (javaScore * pythonScore)); // 곱셈
    System.out.println("/ 연산 결과 : " + (javaScore / pythonScore)); // 나눗셈(정수와 정수의 나눗셈이므로 데이터 실수에 대한 데이터 손실 발생)
    System.out.println("% 연산 결과 : " + (javaScore % pythonScore)); // 나머지

    // 복합대입연산자
    int score = 5;
    score += 1; //score = score + 1과 같다.
    score -= 1; //score = score - 1과 같다.
    score *= 1; //score = score * 1과 같다.
    score /= 1; //score = score / 1과 같다.
    score %= 1; //score = score % 1과 같다.

  }
}
