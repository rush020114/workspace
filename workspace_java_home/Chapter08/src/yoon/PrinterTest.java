package yoon;

public class PrinterTest {
  public static void main(String[] args) {
    // 인터페이스는 메서드 몸체를 생성하지 못하기에 인스턴스를 생성할 순 없지만 참조변수는 선언할 수 있다.
    // 인터페이스형 참조변수는 Printable 인터페이스를 구현한 클래스를 참조할 수 있게 된다.
    // 단 Printable 인터페이스 안에 정의된 추상메서드만 사용할 수 있다.

    String doc = "This is a report about";

    // 인터페이스에서 명시한 메서드를 이용함으로써 프린트하는 방법은 각자 다르지만 똑같은 메서드를 사용할 수 있게 된다.
    Printable prn1 = new SPrinterDriver();
    prn1.print(doc);
    Printable prn2 = new LPrinterDriver();
    prn2.print(doc);
  }
}
