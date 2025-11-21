package theory.generic;

// extends를 타입 매개변수에 활용 시 타입 인자로 Integer, Double만 올 수 있음.
// 이런 제한 조건을 두는 이유는 개발자들이 Number를 들어온다고 생각을 해놓고도
// Number에 관련 없는 값들을 집어넣는 실수를 할 수도 있기 때문이다.(extends를 써야 Number 또는 Number를 상속 받은 Interger의 메서드 사용 가능)
public class BoxExtends <T extends Number>{
  private T ob;

  public T get(){
    return ob;
  }

  public void set(T o){
    ob = o;
  }

  public int toIntValue(){
    return ob.intValue();
  }
}
