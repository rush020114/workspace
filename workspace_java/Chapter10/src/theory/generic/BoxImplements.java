
package theory.generic;
interface Eatable{
  String eat();

}

class AppleImplements implements Eatable{
  public String eat(){
    return "It tastes so good!";
  }
}
// T는 Eatable을 구현한 타입인자만 들어올 수 있어서 eat 메서드를 사용할 수 있다.
public class BoxImplements<T extends Eatable> {

  private T ob;

  public void set(T o){
    ob = o;
  }
  public String get(){
    return ob.eat();
  }

}
