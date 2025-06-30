package 이론;

public class CountTest2 {
  public static void main(String[] args){
    System.out.println(Count.cnt);
    Count.cnt = 5;
    System.out.println(Count.cnt);
    Count.cnt = 10;
    System.out.println(Count.cnt);
    Count c1 = new Count();
    System.out.println(Count.cnt);
  }
}
