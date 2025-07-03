package yoon;

// 상속은 IS-A 관계일 때 하는 것이 적절하다.
public class MobilePhone {
  protected String number;

  public MobilePhone(String num){
    number = num;
  }

  public void answer(){
    System.out.println("Hi~ from " + number);
  }
}

class SmartPhone extends MobilePhone{
  private String androidVer;
  public SmartPhone(String num, String ver){
    super(num);
    androidVer = ver;
  }
  public void playApp(){
    System.out.println("App is running in " + androidVer);
  }
}