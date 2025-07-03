package theory;

public class CakeTest {
  public static void main(String[] args){
    // 다형성 : 상속관계에서 부모클래스로 자식클래스의 객체를 생성할 수 있다.
    // 장점 : 서로 다른 클래스 자료형을 일괄적으로 관리!

    Cake cake = new Cake();
    cake.eatCake();
    Cake cake1 = new StrawberryCheeseCake();
    cake1.eatCake();
    CheeseCake cheeseCake = new StrawberryCheeseCake();
    cheeseCake.eatCake();
    cheeseCake.eatCheeseCake();
    StrawberryCheeseCake strawberryCheeseCake = new StrawberryCheeseCake();
    strawberryCheeseCake.eatStrawberryCheeseCake();
    StrawberryCheeseCake cake2 = (StrawberryCheeseCake) cake1; // cake1은 자신이 딸기치즈케이크인 것을 몰라 케이크 기능만 사용한다. 하지만 강제 형변환을 통해 딸기치즈 케이크인 것을 일깨워주면 딸기치즈 케이크가 된다.
    cake2.eatStrawberryCheeseCake(); // 딸기 치즈케이크가 되어 딸기치즈케이크 기능을 사용할 수 있다.


  }
}
