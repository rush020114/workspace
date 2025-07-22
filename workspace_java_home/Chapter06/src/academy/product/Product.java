package academy.product;

public class Product {
  private int prodId;
  private String prodInfo;
  private String creator;
  private int price;

  public Product(String prodInfo, String creator, int price) {
    this.prodInfo = prodInfo;
    this.creator = creator;
    this.price = price;
  }

  public int getProdId() {
    return prodId;
  }

  public void setProdId(int prodId) {
    this.prodId = prodId;
  }

  public String getProdInfo() {
    return prodInfo;
  }

  public void setProdInfo(String prodInfo) {
    this.prodInfo = prodInfo;
  }

  public String getCreator() {
    return creator;
  }

  public void setCreator(String creator) {
    this.creator = creator;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String toString(){
    return "상품ID: " + prodId + ", 상품설명: " + prodInfo + ", 생산자: " + creator + ", 가격: " + price;
  }
}
