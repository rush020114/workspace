package 이론;

public class Computer {
  String brand;
  int price;

  public Computer(String brand, int price){
    this.brand = brand;
    this.price = price;
  }

  public void display(){
    System.out.println("브랜드 : " + brand);
    System.out.println("가격 : " + price);
  }
}
