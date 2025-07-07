package theory;

public class TvUser {
  public static void main(String[] args){
    // 삼성티비 설치한 후 LG티비 설치하면 자료형도 바꿔야 하고 메서드명도 다 바꾸어야 해서 실수할 확률이 늘어난다.
    // interface를 이용해 메서드에 규약을 줌으로써 한결 변환이 쉬워짐.

    // 인터페이스는 인터페이스 만으로는 객체 생성 불가!
    // 단, 인터페이스를 구현한 클래스의 생성자 호출을 통해 인터페이스 객체 생성 가능!
    Tv tv = new SamsungTv();
    tv.turnOn();
    tv.volumeUp();
    tv.volumeDown();
    tv.turnOff();
  }
}
