public class Operator {
  public static void main(String[] args){
    //연산자
    int num1 = 7;
    int num2 = 3;

    System.out.println("num1 + num2 = " + (num1 + num2)); // 변수 num1과 num2의 합(괄호를 없애면 문자열으로 변환)
    System.out.println("num1 - num2 = " + (num1 - num2)); // 변수 num1과 num2의 차
    System.out.println("num1 * num2 = " + (num1 * num2)); // 변수 num1과 num2의 곱
    System.out.println("num1 / num2 = " + (num1 / num2)); // 변수 num1과 num2의 몫(정수와 정수의 연산이므로 int형(소수의 데이터 손실))
    System.out.println("num1 % num2 = " + (num1 % num2)); // 변수 num1과 num2의 나머지

    System.out.println(7.0 / 3.0); // 실수와 실수의 나눗셈은 double형

    //복합대입연산자
    int a = 1;
    a = a + 1; // a에 1을 더하겠다.
    a += 1; // 이 값은 위의 문장과 같다.

    short num = 7;

    // short와 int의 연산이므로 num에 int가 담기는 상황이며
    // num은 short이므로 강제 형변환을 해줘야 하여 밑에 처럼 작성
    num = (short)(num + 77);
    System.out.println(num);

    // 복합대입연산자는 형변환 고려없이 작성 가능
    // 다만 이런 형변환 방식은 추천하지 않음
    // 위의 문장처럼 명확하게 나타내는 것이 좋음
    num = 7; // num을 7로 덮어씌움
    num += 77L; // 이 문장은 위의 형변환과 같다.
    System.out.println(num);

    int rate = 3;
    // 정수와 실수가 합쳐지며 double로 형변환이 이루어짐
    // 그래서 데이터 손실을 감수하고 강제 형변환을 시켜줌
    rate = (int)(rate * 3.5);

    rate = 3; //  변수 rate를 3으로 덮어씌움
    rate *= 3.5; // 복합대입연산자를 씀으로 위의 문장 연산과정이랑 똑같이 됨(추천X)
  }
}
