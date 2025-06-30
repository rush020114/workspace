package 이론;

public class Bank {
  int money;
  String owner;
  static double iyul;

  static{
    iyul = 5.0;
  }

  public Bank(String owner){
    money = 10000;
    this.owner = owner;
  }

  public static void aaa(){ // static부터 해석하기에 money는 해석하기 전이므로 오류가 난다.
    // System.out.println(money);
    System.out.println(123); // 그러므로 해석 순서에 영향을 받지 않는 출력문은 상관없다.
    // bbb(); 메서드도 아직 해석되지 않아서 호출할 수 없다.
  }

  public void bbb(){
    System.out.println("aaa");
  }
}
