package academy;

public class Rectangle2 {
  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public Rectangle2(){

  }

  public Rectangle2(int x1, int y1, int x2, int y2){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public void set(int x1, int y1, int x2, int y2){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public int square(){
    return Math.abs(x2 - x1) * Math.abs(y2 - y1);
  }

  public void show(){
    System.out.println("사각형의 넓이 : " + square());
    System.out.println("x1: " + x1 + ", y1: " + y1 + ", x2: " + x2 + ", y2: " + y2);
  }

  public boolean equals(Object r){
    return square() == ((Rectangle2)r).square();
  }
}
