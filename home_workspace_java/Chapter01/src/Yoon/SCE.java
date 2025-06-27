public class SCE {
  public static void main(String[] args){
    // SCE : 불필요한 연산을 생략하는 기법(이 때문에 연산이 반영 안 되는 현상이 생길 수 있음)
    // 이 때문에 한 줄에 너무 많은 연산식을 만들지 말고 연산을 따로 떼어 해야 한다.
    int num1 = 0;
    int num2 = 0;
    boolean result;

    // and연산이므로 앞의 것이 틀리면 연산을 생략하여 num2의 계산이 반영되지 않음
    result = (num1 += 10) < 0 && (num2 += 10) < 0;
    System.out.println(result);
    System.out.println(num1);
    System.out.println(num2);
    System.out.println();

    // or연산이므로 앞의 것이 맞으면 연산을 생략하여 num2의 계산이 반영되지 않음
    result = (num1 += 10) > 0 || (num2 += 10) > 0;
    System.out.println(result);
    System.out.println(num1);
    System.out.println(num2);

    //해결
    num1 = 0;
    num1 += 10;
    num2 += 10;
    result = num1 < 10 && num2 > 10;

    System.out.println(result);
    System.out.println(num1);
    System.out.println(num2);

    num1 = 0;
    num2 = 0;
    num1 += 10;
    num2 += 10;
    result = num1 > 10 || num2 > 10;

    System.out.println(result);
    System.out.println(num1);
    System.out.println(num2);

  }
}
