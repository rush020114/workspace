package theory;

public class Restaurant {
  private String name;
  private Cookable chef;

  // 영업 중
  public void open(){
    chef.cook();
  }
}