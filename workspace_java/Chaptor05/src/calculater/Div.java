package calculater;

public class Div {
  private int a;
  private int b;

  public void setValue(int a, int b){
    this.a = a;
    this.b = b;
  }

  public double calculate(){
    return a / (double)b;
  }
}
