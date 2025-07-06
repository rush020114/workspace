package academy;

public class Rectangle {
  private int width;
  private int height;

  public Rectangle(int width, int height){
    this.width = width;
    this.height = height;
  }

  public int square(){
    return width * height;
  }

  @Override
  public boolean equals(Object rectangle){ // Object equals 메서드 주소값 비교가 아닌 사각형 넓아를 비교하는 메서드로 오버라이딩
    return square() == ((Rectangle)rectangle).square();
  }
}
