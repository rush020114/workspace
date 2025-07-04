package theory;

// 클래스가 어떠한 클래스도 상속받고 있지 않다면
// 자동으로 object 클래스를 상속받는다.
// 결론 - 자바의 모든 클래스느 Object 클래스를 상속하고 있다!
//     - 모든 클래스는 Object 클래스의 변수와 메서드를 사용할 수 있다.

// Object 클래스에서 선언된 equals()
// 객체가 같음을 판단할 때는 equals() 메서드 사용 권장.
// equals() 메서드의 원래 기능 : 참조값(주소값)이 같으면 리턴 true;
// 단, 객체가 같다는 정의는 여러분이 정의해서 사용하세요.
// -> : 결론 : Object 클래스의 equals() 메서드를 오버라이딩해서 사용하세요.

// Object 클래스에서 선언된 toString()
// toString() 메서드는 객체를 문자열로 표현할 때 사용하라고 하는 메서드
// toString() 메서드의 원래 기능 : 객체의 주소값을 문자열로 표현
// 객체명만 출력해도 자동으로 객체의 toString() 메서드가 호출된다.

class Q {
  public void testQ(int a, String b){
    System.out.println("111");
  }
}

public class Tv extends Q{
  public void turnOn(){
    System.out.println("TV 전원 켬");
  }

  public void testQ(int a, String b){
    System.out.println(222);
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}

class Rect{
  int width;
  int height;

  public Rect(int width, int height){
    this.width = width;
    this.height = height;
  }

  // @를 annotation(어노테이션)이라 부름
  // 개발자의 실수를 줄이기 위해 사용하는 보조 수단
  @Override
  public String toString() {
    return "Rect{" +
            "width=" + width +
            ", height=" + height +
            '}';
  }

  // Object는 모든 클래스의 부모 클래스이기 때문에 객체로 자식 클래스를 받을 수 있다.
  // 오버라이딩은 메서드명 매개변수가 같아야 한다. 그래서 자바는 오버라이딩 메서드를 만드는 기능을 제공한다.
  @Override
  public boolean equals(Object obj) { // Object obj : 매개변수로 자료형을 따지지 않는다는 뜻
    // 위의 매개변수로 받은 obj는 다른 객체를 받을 수 있지만 다형성으로 인해 Object의 기능밖에 사용하지 못하게 된다.
    // 그래서 형변환을 시켜주어 자식 클래스의 변수나 메서드에 접근한다.
    return width == ((Rect)obj).width && height == ((Rect)obj).height;
  }
}