package yoon;

class InstCnt{
  static int instNum = 100;
  public InstCnt(){ // 클래스 변수는 생성자로 초기화하면 인스턴스 생성마다 초기화되므로 사용하면 안 된다.
    instNum++;
    System.out.println("인스턴스 생성 : ");
  }
}

class OnlyClassNoInstance {
  public static void main(String[] args) {
    InstCnt instCnt = new InstCnt();
    System.out.println(instCnt.instNum);
    InstCnt.instNum -= 15;
    System.out.println(InstCnt.instNum);
  }
}
