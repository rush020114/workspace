package 실습;

public class 메서드문제1_1_7 {
  public static void main(String[] args) {
    hello();
    int1(5);
    string1("안녕");
    int2(1, 2);
    int3(3, 5, 7);
    int4(5, 3);
    int5(4, 6);
  }

  public static void hello(){
    System.out.println("안녕하세요");
  }
  public static void int1(int int1_1){
    System.out.println(int1_1);
  }
  public static void string1(String string1_1){
    System.out.println(string1_1);
  }
  public static void int2(int int2_1, int int2_2){
    System.out.println(int2_1 + int2_2);
  }
  public static void int3(int int3_1, int int3_2, int int3_3){
    System.out.println(int3_1 * int3_2 * int3_3);
  }
  public static void int4(int int4_1, int int4_2){
    System.out.println((int4_1 / int4_2) + " " + (int4_1 % int4_2));
  }
  public static void int5(int int5_1, int int5_2){
    System.out.println(int5_1 + " " + int5_2);
  }
}
