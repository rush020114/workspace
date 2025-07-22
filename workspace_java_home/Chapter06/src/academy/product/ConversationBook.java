package academy.product;

public class ConversationBook extends Book{
  private String language;

  public ConversationBook(String prodInfo, String creator, int price, String isbn, String writer, String title, String language) {
    super(prodInfo, creator, price, isbn, writer, title);
    this.language = language;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public String toString(){
    return super.toString() + ", 언어: " + language;
  }
}
