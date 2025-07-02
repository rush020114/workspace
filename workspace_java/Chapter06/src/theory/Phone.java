package theory;

class ClassicPhone{

}

public class Phone extends ClassicPhone{
  private String modelName;
  private int price;

  public Phone(){
    modelName = "";
    price = 0;
  }

  // 상속 관계에 있는 클래스 중 자식 클래스의 생성자 첫 줄에는
  // 부모클래스의 생성자를 호출하는 super() 키워드가 숨겨져 있다.
  // 단, 생성자에 자신의 생성자를 호출하는 this()라는 키워드가 있으면,
  // super() 키워드가 없는 것으로 간주한다.

  // this()가 있으면 부모 클래스가 있어도 super()가 필요없다.
  // this()는 자신의 클래스 안의 생성자를 실행하기 때문에 부모 생성자를 두 번 호출하는 일이 생긴다.
  public Phone(String modelName){
    this(); // 자신의 매개변수가 없는 생성자를 호출한다.
    this.modelName = modelName;
  }

  public Phone(String modelName, int price){
    this(modelName);
    this.price = price;
  }

}