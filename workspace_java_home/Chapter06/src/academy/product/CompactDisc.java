package academy.product;

public class CompactDisc extends Product {
  private String albumTitle;
  private String singer;

  public CompactDisc(String prodInfo, String creator, int price, String albumTitle, String singer) {
    super(prodInfo, creator, price);
    this.albumTitle = albumTitle;
    this.singer = singer;
  }

  public String getAlbumTitle() {
    return albumTitle;
  }

  public void setAlbumTitle(String albumTitle) {
    this.albumTitle = albumTitle;
  }

  public String getSinger() {
    return singer;
  }

  public void setSinger(String singer) {
    this.singer = singer;
  }

  public String toString(){
    return super.toString() + ", 앨범 제목: " + albumTitle + ", 가수: " + singer;
  }
}
