package 이론;

public class BankTest {
  public static void main(String[] args){
    Bank b1 = new Bank("kim");
    Bank b2 = new Bank("lee");
    Bank b4 = new Bank("hong");
    Bank b3 = new Bank("park");
    Bank b5 = new Bank("choi");

    System.out.println(Bank.iyul);
    Bank.iyul += 3;
    System.out.println(Bank.iyul);

    print();
    print();

  }

  public static void print(){ // static을 뺄 경우 main과 동시에 해석되지 못해 print 메서드 호출이 불가하다.
    System.out.println(123);
  }
}
