public class UnaryAdd {
  public static void main(String[] args){
    // 단항연상자 (+, -, ++, --)
    // 부호연산자
    // + : 숫자 앞에 +가 붙으면 부호 그대로의 int형 숫자로 반환
    // - : 숫자 앞에 -가 붙으면 부호 반대로의 int형 숫자로 반환
    short num1 = 5;
    System.out.println(+num1); // 앞에 +가 붙으면서 int5로 반환
    System.out.println(-num1); // 앞에 -가 붙으면서 int-5로 반환

    short num2 = 7;
    short num3 = (short)+num2; // int형으로 변했으므로 강제형변환을 하지 않으면 오류
    short num4 = (short)-num2; // int형으로 변했으므로 강제형변환을 하지 않으면 오류
    System.out.println(num3);
    System.out.println(num4);
  }
}
