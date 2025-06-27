package 실습;

import java.util.Arrays;

public class Song {
  String title;
  String artist;
  String album;
  int year;
  String[] composer;

  public void setSongInfo(String newTitle, String newArtist, String newAlbum, int newYear, String[] newComposer){
    title = newTitle;
    artist = newArtist;
    album = newAlbum;
    year = newYear;
    composer = newComposer;
  }
  public void printSongInfo(){
    System.out.println(title);
    System.out.println(artist);
    System.out.println(album);
    System.out.println(year);
    System.out.println(Arrays.toString(composer));
  }
}
