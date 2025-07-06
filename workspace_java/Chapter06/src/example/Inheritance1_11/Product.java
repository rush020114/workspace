package example.Inheritance1_11;

public class Product {
  private int productId;
  private String description;
  private String producer;
  private int price;

  public Product(int productId, String description, String producer, int price){
    this.productId = productId;
    this.description = description;
    this.producer = producer;
    this.price = price;
  }

  @Override
  public String toString() {
    return  "상품번호 : " + productId + ", 상품설명 : " + description + ", 생산자 : " + producer + ", 가격 : " + price;
  }
}
