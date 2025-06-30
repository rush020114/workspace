package 실습;

public class SongTest {
  public static void main(String[] args){
    Song s1 = new Song();
    String[] composer = {"김", "이", "박"};
    s1.setSongInfo("노래", "가수", "앨범", 2025, composer);
    s1.printSongInfo();
  }
}
