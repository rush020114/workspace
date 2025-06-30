package list;

public class Fruit {
  private String name;
  private String country;
  private int price;

  public Fruit(String name, String country, int price) {
    this.name = name;
    this.country = country;
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() { // 클래스의 모든 변수를 출력하는 메서드
    return "Fruit{" +
            "name='" + name + '\'' +
            ", country='" + country + '\'' +
            ", price=" + price +
            '}';
  }
}
