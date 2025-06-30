package yoon;

class AccessWay{
  static int num;
  AccessWay(){
    incrCnt();
  }
  void incrCnt(){
    num++;
  }
}

class ClassVarAccess {
  public static void main(String[] args) {
    AccessWay way = new AccessWay();
    way.num++; // 외부에서 인스턴스를 통한 접근
    AccessWay.num++; // 외부에서 클래스 이름을 통한 접근
    System.out.println("num = " + AccessWay.num); // AccessWay 인스턴스가 생성되자마자 static부터 실행되므로 1로 초기화됐으므로 마지막은 3이 나옴
    way.incrCnt(); // 인스턴스의 메서드 실행(공용변수 +1됨)
    System.out.println(AccessWay.num);
  }
}
