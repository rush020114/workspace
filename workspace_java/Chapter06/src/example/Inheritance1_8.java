package example;

public class Inheritance1_8 {
  public static void main(String[] args){
    Bb bp = new Bb();
    Bb bp1 = new Bb(10);
    Bb bp2 = new Bb(10, 20);
    Bb bp3 = new Bb(10, 20, 30);
    Bb bp4 = new Bb(10, 20, 30, 40);
    bp.disp();
    bp1.disp();
    bp2.disp();
    bp3.disp();
    bp4.disp();
  }
}

class Aa{
  private int x;
  private int y;
  public Aa(){
    x = 1;
    y = 1;
  }

  public Aa(int x1){
    x = x1;
    y = 1;
  }

  public Aa(int x1, int y1){
    x = x1;
    y = y1;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
}

class Bb extends Aa{
  private int x;
  private int y;

  public Bb(){
    x = 1;
    y = 1;
  }
  public Bb(int x1){
    super(x1);
    x = 1;
    y = 1;
  }
  public Bb(int x1, int y1){
    super(x1, y1);
    x = 1;
    y = 1;
  }
  public Bb(int x1, int y1, int x2){
    super(x1 ,y1);
    x = x2;
    y = 1;
  }
  public Bb(int x1, int y1, int x2, int y2){
    super(x1 ,y1);
    x = x2;
    y = y2;
  }

  public void disp(){
    System.out.println("x = " + getX() + ", y = " + getY() + ", x = " + x + ", y = " + y);
  }
}