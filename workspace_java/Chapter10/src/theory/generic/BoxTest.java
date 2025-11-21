package theory.generic;

public class BoxTest {
  // 대표적인 오류 없이 잘못된 코드로
  // Apple, Orange 인스턴스를 넣지 않고
  // 문자열을 넣고 형변환도 없이 정상실행돼서
  // 의도한 결과가 나오지 않는 코드이다.
  // 제대로 하려면 문자열 대신 객체를 넣고
  // 밑의 주석을 풀어 형변환을 하고
  // 주석의 출력문을 실행해야 한다.

  public static void main(String[] args){
    Box aBox = new Box();
    Box oBox = new Box();

    aBox.set("new Apple()");
    oBox.set("new Orange()");

    Apple ap = (Apple) aBox.get();
    Orange og = (Orange) oBox.get();

    // System.out.println(aBox.get());
    // System.out.println(oBox.get());

    System.out.println(ap);
    System.out.println(og);
  }
}
