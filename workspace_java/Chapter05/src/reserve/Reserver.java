package reserve;
// 예약자 클래스의 멤버변수 : 사람이름,
public class Reserver {
  private String name;

  public Reserver(String name){
    this.name = name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

  @Override
  public String toString(){
    return name + " ";
  }
}
