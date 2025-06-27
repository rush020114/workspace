public class OperatorTest5 {
  public static void main(String[] args) {
    // 조건 연산자(삼항 연산자)
    // 문법 -> 조건식 ? 값1 : 값2
    // 조건식에는 참/거짓을 판단할 수 있는 연산식
    // 값1은 조건식 결과가 참일 때 나오는 값, 값2는 조건식 결과가 거짓일 때 나오는 값
    int javaScore = 83;
    // javaScore가 60을 초과하면 합격을 출력 그렇지 않다면 불합격을 출력
    System.out.println(javaScore > 60 ? "합격" : "불합격"); // 조건식이 참이므로 합격 출력

    int pythonScore = 55;
    // pythonScore가 javaScore보다 크다면 합격을 문자열 result에 저장, 그렇지 않다면 불합격을 저장
    // 이 연산식의 결과값은 문자열
    String result = pythonScore > javaScore ? "합격" : "불합격"; // 조건식이 거짓이므로 불합격 저장
    System.out.println("Python 시험 결과 : " + result);
  }
}
