package theory.generic;

// 타입 매개변수의 이름 규칙
// 한 문자, 대문자
public class DBox<L, R> {
  private L left;
  private R right;

  public void set(L o, R r){
    left = o;
    right = r;
  }

  public String toString(){
    return left + " & " + right;
  }
}
