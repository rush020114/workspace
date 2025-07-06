package example.Inheritance1_11;

public class CompactDisc extends Product{
  private String albumTitle;
  private String singer;

  public CompactDisc(int productId, String description, String producer, int price, String albumTitle, String singer){
    super(productId, description, producer, price);
    this.albumTitle = albumTitle;
    this.singer = singer;
  }

  @Override
  public String toString() {
    return super.toString() + ", 앨범제목 : " + albumTitle + ", 가수 : " + singer;
  }
}
