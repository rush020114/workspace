import java.util.Scanner;

public class IfExam05 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num1, num2;
    System.out.print("첫번째 수 : ");
    num1 = sc.nextInt();
    System.out.print("첫번째 수 : ");
    num2 = sc.nextInt();
    System.out.print("연산자 : ");
    String op = sc.next();

    int num3 = num1 + num2;
    int num4 = num1 - num2;
    int num5 = num1 * num2;
    double num6 = (double)num1 / (double)num2; // num1과 num2의 자료형을 실수로 강제형변환 시켜 실수 num6에 저장

    if ((op.equals("+")) && (num3 == num1 + num2)) { // 문자열+이면서 num1 + num2의 값이 num3이면
      System.out.println(num1 + op + num2 + "=" + num3);
    }

    else if ((op.equals("-")) && (num4 == num1 - num2)) {
      System.out.println(num1 + op + num2 + "=" + num4);
    }

    else if ((op.equals("*")) && (num5 == num1 * num2)) {
      System.out.println(num1 + op + num2 + "=" + num5);
    }

    /*
    주의 : 위의 나눗셈 연산을 double로 강제형변환 시키고 num6의 값에 저장했으므로
    조건의 num1, num2에 double이 빠지면 다른 식이 되어 버려 이 조건문은 false가 되어 버림.
    num6의 값은 이미 위에서 실수끼리의 연산으로 인해 실수로 저장되었으므로 강제형변환 시킬 필요 없음.
    */
    else if ((op.equals("/")) && (num6 == (double)num1 / (double)num2)) {
      // 위의 나눗셈 연산과 일치시키는 식 (double이 빠지면 다른 식이 됨.)
      System.out.println(num1 + op + num2 + "=" + num6);
      // 앞서 계산한 num1과 num2는 강제 형변환이기 때문에 그 값은 여전히 int이며 num6의 값은 앞의 실수끼리의 연산으로 데이터 손실 없는 실수.
    }

    else{
      System.out.println("연산자를 잘못 입력하셨습니다.");
    }
  }
}
