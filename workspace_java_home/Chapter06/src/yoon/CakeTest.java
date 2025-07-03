package yoon;

public class CakeTest {
  public static void main(String[] args) {
    CheeseCake cheeseCake = new CheeseCake();
    CheeseCake cheeseCake1 = cheeseCake;

    Cake cake = new CheeseCake();
    CheeseCake cheeseCake2 = (CheeseCake)cake; // 아무리 객체를 CheeseCake로 받아도 cake는 자료형이 Cake이므로 강제 형변환을 해주지 않으면 컴파일 오류 발생
    cheeseCake2.milky();

    Cake[] cakes = new CheeseCake[10]; // 부모 클래스의 배열이므로 자식 클래스의 배열을 받을 수 있다(참조할 수 있다.).
    // 상속의 관계가 배열의 인스턴스 관계까지 이어진다.
    // cakes[0] = new Cake(); // 런터임 오류(현재 치즈케이크 배열을 참조하므로 치즈 케이크 자료형만 들어갈 수 있다.)
    Cake cake1 = new StrawberryCheeseCake();
    CheeseCake cake2 = new StrawberryCheeseCake();
    StrawberryCheeseCake strawberryCheeseCake = new StrawberryCheeseCake();
    cake1.yummy(); // super.을 적용하기 전은 메서드 오버라이딩으로 자식클래스의 메서드를 사용할 수 없지만 사용할 수 있게 된다. (두 번 오버라이딩됐으므로 딸기치즈케이크 메서드 실행)
    // 적용 후에는 부모 클래스를 호출하게 됨.
    cake2.yummy(); // super.을 적용하기 전은 오버라이딩 실행되므로 딸기치즈캐이크 메서드 실행
    // 적용 후에는 부모 클래스를 호출하게 됨. 케이크도 참조하고 있으므로 다 출력
    // 만약 케이크가 치즈케이크만 참조하면 그 자식 태그의 오버라이딩은 실행시킬 수 없음.
  }
}
