package yoon;

// 모든 클래스는 Object 클래스를 상속한다.
public class Obj {
  public void println(Object x){ // Object는 모든 클래스의 최상위 클래스이니 모든 인스턴스는 Object매개변수에 인자를 전달할 수 있다.
    String s = x.toString();

  }
}
class ParentAdder{
  public int add(int a, int b){
    return a + b;
  }
}

class ChildAdder{
  // @Override <-가 쓰이면 오버라이딩했다는 것을 확실하게 표시할 수 있는데 Override를 제대로 하지 못하면 빨간줄이 뜬다.
  public double add(double a, double b){
    return a + b;
  }
}