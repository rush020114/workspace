package yoon;

// LPrinterDriver는 Printable 인터페이스를 구현한다.
public class LPrinterDriver implements Printable{

  // 인터페이스를 사용하면 해당클래스의 사용방법을 명시해 프로그램을 만들 때 혼동을 줄일 수 있다.
  @Override
  public void print(String doc){
    System.out.print(doc);
    System.out.println(" From LG printer");
  }
}
