public class 연산자_3 {
  public static void main(String[] args) {
    // 삼항연산자 : 항이 세 개 있는 연산자, if - else와 같은 기능
    // 문법 -> 참 또는 거짓을 판별할 수 있는 조건 ? 참일 때 값 : 거짓일 때 값;

    int num = 3;
    String result = "";
    if (num > 1) {
      result = "참";
    }

    else{
      result = "거짓";
    }

    System.out.println(result);

    // ----------------------------
    int a = 3;
    String newResult = "";
    // 삼항연산자
    newResult = a > 1 ? "참" : "거짓";
    System.out.println(newResult);

    // 소괄호 안의 내용을 출력하고 한 줄 개행한다.
    // 만약 소괄호 안의 내용이 연산 가능하면 연산 결과를 출력한다.
    int b = 10; // 위의 문장을 좀 더 간결하게 한 것
    String newerResult = b > 4 ? "참" : "거짓"; // newerResult의 값을 선언과 동시에 초기화
    System.out.println(newerResult);

    int c = 7;
    System.out.println(c > 5 ? "참" : "거짓"); // 출력문은 연산이 가능하면 연산결과를 출력하므로 String값으로 출력

  }
}
