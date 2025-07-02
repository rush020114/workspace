package example;

public class Inheritance1_11_1 {
  public static void main(String[] args) {
    Bbb bbb = new Bbb();
    Bbb bbb1 = new Bbb(10);
    Bbb bbb2 = new Bbb(10, 20);
    Bbb bbb3 = new Bbb(10, 20, 30);
    Bbb bbb4 = new Bbb(10, 20, 30, 40);

    bbb.disp();
    bbb1.disp();
    bbb2.disp();
    bbb3.disp();
    bbb4.disp();
  }
}

class Aaa {
  private int x;
  private int y;

  public Aaa(){
    x = 1;
    y = 1;
  }

  public Aaa(int x){
    this.x = x;
    y = 1;
  }

  public Aaa(int x, int y){
    this.x = x;
    this.y = y;
  }

  public void disp(){
    System.out.println(", x = " + x + ", y = " + y); // 좋은 코드는 자기 변수는 자기가 관리해야 한다.
  }
}

class Bbb extends Aaa{
  private int x;
  private int y;

  public Bbb(){
    x = 1;
    y = 1;
  }

  public Bbb(int x){
    this.x = x;
    y = 1;
  }

  public Bbb(int x, int y){
    this.x = x;
    this.y = y;
  }

  public Bbb(int x, int y,int xx){
    super(xx);
    this.x = x;
    this.y = y;
  }

  public Bbb(int x, int y, int xx, int yy){
    super(xx, yy);
    this.x = x;
    this.y = y;
  }

  public void disp(){
    System.out.print("x = " + x + ", y = " + y);
    super.disp(); // 별말이 없고 변수나 메서드의 이름이 같다면 자기 클래스의 것을 호출하기 때문에 super.를 썼다.
  }
}