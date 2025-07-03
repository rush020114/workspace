package theory;

// 객체를 받았을 때 불편해지면 못 받고, 객체를 받았을 때 불편함을 못 느끼면 받을 수 있다.
public class PhoneTest {
  public static void main(String[] args) {

    // 다형성 : 객체의 형태가 다양하다.
    // 객체 생성 방법을 다양하게 가질 수 있다.
    // 부모 클래스는 자식객체를 전부 받아들인다.
    // 자식 클래스는 부모객체를 못 받는다.
    MobilePhone mobilePhone = new MobilePhone();
    SmartPhone smartPhone = new SmartPhone();

    // 이 객체는 스마트폰(스마트폰을 넘겨받았으므로)이지만 모바일폰으로 인식하여(모바일폰밖에 모르기에) 모바일폰 기능만 사용한다.
    // mobilePhone1 객체의 실체는 스마트폰 객체다!
    // 단, 현재는 모바일폰 객체로 인식을 하고 있기 때문에
    // 모바일폰 클래스에서 정의한 메서드, 멤버변수만 사용 가능!
    MobilePhone mobilePhone1 = new SmartPhone(); // 모바일폰을 주세요.했더니 스마트폰을 넘겨줌(가능)

    // 형변환을 통해 모바일폰 객체를 스마트폰 객체로 변경할 수 있다.
    SmartPhone smartPhone1 = (SmartPhone)mobilePhone1;
    smartPhone1.playApp();

    // 모바일폰 객체를 강제로 스마트폰 객체로 형변환할 수는 없다.
    // 실행 전 빨간줄(빨간글자)로 알려주는 오류를 컴파일 오류라 한다. (코드 작성 -> 자동으로 코드를 컴퓨터 언어로 변환이 안 됨)
    // 빨간줄이 생기지 않지만, 실행 시 발생하는 오류를 런타임 오류라 한다. (코드 실행 후 오류)
    MobilePhone mobilePhone2 = new MobilePhone(); // 모바일 폰을 달라해서 모바일폰을 받았으므로 모바일폰인 상태이다.
    SmartPhone smartPhone2 = (SmartPhone)mobilePhone2; // 모바일폰이므로 강제로 스마트폰으로 바꿀 수 없다.
    // smartPhone2.playApp(); // 오류



    // SmartPhone smartPhone1 = new MobilePhone(); // 스마트폰을 주세요.했더니 모바일폰을 넘겨줌(불가능)
  }
}