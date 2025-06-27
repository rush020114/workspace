public class PrefixOpPostOp {
  public static void main(String[] args){
    // 증감연산자(++, -- : 각각 변수를 1증감 시킴)
    int num1 = 7;
    System.out.println(++num1); // 변수 앞에 증감연산자가 오면 1증가 후 저장
    System.out.println(++num1);
    System.out.println(num1);

    int num2 = 5;
    System.out.print(num2++ + " "); // 반환 후 증가하므로 5 저장된 값은 6
    System.out.print(num2++ + " "); //앞의 저장된 값 반환 후 증가하므로 6 저장된 값은 7
    System.out.println(num2); // 저장된 값이 7이므로 7

    System.out.print(num2-- +" "); // 반환 후 감소하므로 7 저장된 값은 6
    System.out.print(num2-- +" "); // 앞의 저장된 값 반환 후 감소하므로 6 저장된 값은 5
    System.out.println(num2); // 저장돤 값이 5이므로 5

  }
}
