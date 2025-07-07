package theory;

// implements : 구현
// Printable 인터페이스에 정의한 추상 메서드를 구현해서 SamsungPrinter 클래스를 만들겠다.
// 인증마크에 대한 시험(메서드)가 두 개이므로 반드시 그에 관한 메서드를 두 개 정의
public class SamsungPrinter implements Printable {

  @Override
  public void blackPrint() {
    System.out.println("111");
  }

  @Override
  public void colorPrint() {
    System.out.println(222);
  }
}