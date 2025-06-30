package yoon;

// 캡슐화 : 하나의 클래스에 적절한 클래스를 잘 담는 것


// 적절한 캠슐화의 예시
// 코감기(콧물, 재채기, 코막힘을 동반하는) 치료 기능 클래스
// 클래스를 따로 분리하지 않고 한 곳에 모아 클래스를 일일이 기억할 필요가 없다.
public class SinusCap {
  public void sniTake(){
    System.out.println("콧물이 낫습니다.");
  }

  public void sneTake(){
    System.out.println("재채기가 멎습니다.");
  }

  public void snuTake(){
    System.out.println("코가 뚫립니다.");
  }

  void take(){
    sniTake();
    sneTake();
    snuTake();
  }
}
