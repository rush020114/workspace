package yoon.friend;

public class CompFriend extends Friend{
  private String department;

  public CompFriend(String name, String phone, String department){
    super(name, phone); // 자신의 변수는 자신이 초기화 시켜주는 것이 옳은 코드이므로 부모 클래스의 생성자를 호출하여 직접 초기화하게 한다.
    this.department = department;
  }

  public void show(){
    super.show(); // 호출된 자식 클래스는 다시 super.으로 인해 부모 클래스를 호출하고 전부 사용할 수 있게 된다.
    System.out.println("부서 : " + department);
  }
}
