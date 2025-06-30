package 이론;

public class Book {
  String title;
  String writer;
  int price;

  // this. -> 클래스에서 선언된
  public void setTitle(String title){
    this.title = title;
  }

  public void setBookInfo(String title, String writer, int price){
    this.title = title;
    this.writer = writer;
    this.price = price;
  }
}
