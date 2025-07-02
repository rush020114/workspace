package example.Inheritance1_10;

public class InkJetPrinter extends Printer{
  private int inkLeft;

  public InkJetPrinter(){
    super("잉크젯", "inkjet", "USB", 5);
    inkLeft = 1000;
  }

  public void setInkLeft(int inkLeft){
    this.inkLeft = inkLeft;
  }

  public int getInkLeft(){
    return inkLeft;
  }

  public void getAllLeft(){
    System.out.println("남은 잉크 : " + getInkLeft());
    System.out.println("남은 종이 : " + getLeftPage());
  }

  public void printInkJet(){
    inkLeft -= 5;
    print();
  }
}
