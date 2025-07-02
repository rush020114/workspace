package yoon;

public class Man {
  String name;

  // 하위 클래스가 아무런 인자도 전달 받지 않으면 하위 클래스의 생성자가 하나도 없을 시 자동으로 이 생성자가 생성되어 값을 초기화.
  public Man(){

  }

  // 하위 클래스에서 super키워드(상위 클래스 호출)로 매개변수를 전달받아 상위 클래스에서 직접 값을 초기화할 수 있게 되었다.
  public Man(String name){
    this.name = name;
  }

  public void tellYourName(){
    System.out.println("My name is " + name);
  }
}

// 상속을 하게 되면 Man이 BusinessMan 안에 들어가게 된다.
// 같은 영역에 있으므로 Man의 변수와 메서드를 사용할 수 있게 된다.
// 주의할 점은 Man의 변수나 메서드가 private이면 직접 접근이 불가능해진다.

// 좋은 코드는 클래스 자신의 변수는 자신이 다루는 것이다.(초기화 및 사용)
class BusinessMan extends Man{
  String company;
  String position;

  // 하위 클래스의 생성자는 반드시 상위 클래스의 생성자를 호출해야 한다.
  public BusinessMan(String name, String company, String position){
    super(name);
    this.company = company;
    this.position = position;
  }

  public void tellYourInfo(){
    System.out.println("My company is " + company);
    System.out.println("My position is " + position);
    tellYourName();
  }
}
