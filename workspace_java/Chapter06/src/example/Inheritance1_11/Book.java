package example.Inheritance1_11;

public class Book extends Product{
  private int numISBN;
  private String writer;
  private String title;

  public Book(int productId, String description, String producer, int price, int numISBN, String writer, String title){
    super(productId, description, producer, price);
    this.numISBN = numISBN;
    this.writer = writer;
    this.title = title;
  }

  @Override
  public String toString() {
    return super.toString() + ", ISBN : " + numISBN + ", 저자 : " + writer + ", 제목 : " + title;
  }
}
