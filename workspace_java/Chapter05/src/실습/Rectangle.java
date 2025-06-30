package 실습;

public class Rectangle {
  private int x1;
  private int y1;
  private int x2;
  private int y2;
  Rectangle(){
    x1 = 0;
    y1 = 0;
    x2 = 0;
    y2 = 0;
  }
  public Rectangle(int x1 , int x2, int y1, int y2){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public void set(int x1, int x2, int y1, int y2){
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
  }

  public int square(){
    int width1 = Math.abs(x1 - x2);
    int width2 = Math.abs(y1 - y2);
    return width1 * width2;
  }

  public void show(){
    System.out.print("x1 : " + x1 + " / ");
    System.out.print("y1 : " + y1 + " / ");
    System.out.print("x2 : " + x2 + " / ");
    System.out.println("y2 : " + y2 + " ");
    System.out.println("넓이 : " + square());
  }

  // 인자로 전달된 객체r과 현 객체의 넓이가 같으면 리턴 true
  // 매개변수에 실제로 들어가는 데이터를 인자라 표현한다.
  public boolean equals(Rectangle r){ // 현 객체의 넓이와 비교할 Rectangle클래스의 데이터를 가진 인자가 들어옴.
    return square() == r.square(); // 왼쪽은 현 객체의 넓이(현 객체에서 호출했으므로), 오른쪽은 들어온 인자의 넓이
  }
}
