package Academy;

public class Rectangle {
  private int x1;
  private int y1;
  private int x2;
  private int y2;

  public Rectangle(){
  }

  public Rectangle(int x1, int y1, int x2, int y2){
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
    int width = Math.abs(x1 - x2);
    int height = Math.abs(y2 - y1);
    return width * height;
  }

  public void show(){
    System.out.println("x1좌표 : " + x1 + " y1좌표 : " + y1 + " x2좌표 : " + x2 + " y2좌표 : " + y2);
    System.out.println("넓이 : " + square());
  }

  public boolean equals(Rectangle r){
      return square() == r.square();
  }
}
