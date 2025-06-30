package 실습;

public class ManTest {
  public static void main(String[] args){
    Man m1 = new Man();
    m1.setManInfo("홍길동", 20, "울산");
    m1.printManInfo();
    m1.setName("고길동");
    m1.printManInfo();
    m1.setAge(15);
    m1.printManInfo();
    m1.setAddress("서울");
    m1.printManInfo();
    System.out.println(m1.returnName());
    System.out.println(m1.returnAge());
    System.out.println(m1.returnAddress());
  }
}
