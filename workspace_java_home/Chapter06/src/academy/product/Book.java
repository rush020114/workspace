package academy.product;

public class Book extends Product{
  private String isbn;
  private String writer;
  private String title;

  public Book(String prodInfo, String creator, int price, String isbn, String writer, String title){
    super(prodInfo, creator, price);
    this.isbn = isbn;
    this.writer = writer;
    this.title = title;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String toString(){
    return super.toString() + ", ISBN: " + isbn.substring(4) + ", 책 제목: " + title + ", 저자: " + writer;
  }
}
