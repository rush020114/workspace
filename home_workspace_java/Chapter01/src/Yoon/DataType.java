public class DataType {
  public static void main(String[] args){
    //boolean
    boolean b1 = true; // boolean은 참거짓을 구별하는 데이터이고 true, false밖에 담지 못한다.
    boolean b2 = false;
    System.out.println(b1);
    System.out.println(b2);

    int num1 = 10;
    int num2 = 20;
    System.out.println(num1 < num2); // num1과 num2 중 어떤 것이 더 크냐는 연산의 결과를 출력하므로  true
    System.out.println(num1 > num2);

    //char
    char ch1 = 53953; // 문자를 읽을 수 있는 유니코드가 존재하므로 한글이 나오게 됨
    System.out.println(ch1);
  }
}
