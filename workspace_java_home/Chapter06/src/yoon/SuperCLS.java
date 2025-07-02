package yoon;

public class SuperCLS {

  // static 변수는 상속이 되지 않는다.(누구의 것도 아닌 인스턴스 전체의 공용이기 떄문)
  // 다만 상위 클래스에 static이 있으면 직접 접근 가능한데 하위 클래스도 이름으로 접근은 가능하다.
  static int count = 0;

  public SuperCLS(){
    count++;
  }
}

class subCLS extends SuperCLS{
  public void showCount(){
    System.out.println(count);
  }
}
