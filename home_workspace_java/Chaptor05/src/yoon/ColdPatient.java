package yoon;

class ColdPatient {
  void takeSinus(SinusCap cap){ // SinusCap 클래스를 매개변수로 받음.
    cap.take(); // SinusCap의 take메서드(약을 복용하게 해주는 메서드)를 실행시킴.
  }
}

class OneClassEncapsulation{
  public static void main(String[] args){
    ColdPatient suf = new ColdPatient(); // ColdPatient에 대한 객체 생성과 이를 참조하기 위한 suf 선언
    suf.takeSinus(new SinusCap()); // suf객체의 takeSinus메서드 호출(매개변수로 SinusCap을 받으므로 새로운 객체 생성)
  }
}