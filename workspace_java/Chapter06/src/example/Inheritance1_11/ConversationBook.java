package example.Inheritance1_11;

public class ConversationBook extends Book{
  private String language;

  public ConversationBook(int productId, String description, String producer, int price, int numISBN, String writer, String title, String language){
    super(productId, description, producer, price, numISBN, writer, title);
    this.language = language;
  }

  @Override
  public String toString() {
    return super.toString() + ", 언어 : " + language;
  }
}
