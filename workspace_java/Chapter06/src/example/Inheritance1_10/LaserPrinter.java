package example.Inheritance1_10;

public class LaserPrinter extends Printer{
  private int tonerLeft;

  public LaserPrinter(){
    super("잉크젯", "inkjet", "USB", 5);
    tonerLeft = 1000;
  }

  public void setTonerLeft(int tonerLeft){
    this.tonerLeft = tonerLeft;
  }

  public int getTonerLeft(){
    return tonerLeft;
  }

  public void getAllLeft(){
    System.out.println("남은 토너 : " + getTonerLeft());
    System.out.println("남은 종이 : " + getLeftPage());
  }

  public void printLaser(){
    tonerLeft -= 5;
    print();
  }
}
