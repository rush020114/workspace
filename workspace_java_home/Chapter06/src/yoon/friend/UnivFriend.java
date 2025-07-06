package yoon.friend;

public class UnivFriend extends Friend{
  private String major;

  public UnivFriend(String name, String phone, String major){
    super(name, phone);
    this.major = major;
  }

  public void show(){
    super.show();
    System.out.println("전공 : " + major);
  }
}
