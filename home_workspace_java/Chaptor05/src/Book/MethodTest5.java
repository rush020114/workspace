package Book;

public class MethodTest5 {
  public static void main(String[] args){
    int firstScore = 90;
    int secondScore = 33;

    System.out.println("before(firstScore) : " + firstScore);
    System.out.println("before(secondScore) : " + secondScore);

    swapScore(firstScore, secondScore);

    System.out.println("after(firstScore) : " + firstScore); // main메서드에서 사용된 firstScore와 swapScore에서 사용된 매개변수는 서로 독립적이다.
    System.out.println("after(secondScore) : " + secondScore);
  }

  public static void swapScore(int score1, int score2){
    int temp;
    temp = score1;
    score1 = score2;
    score2 = temp;
    System.out.println(score1);
    System.out.println(score2);
  } // swap메서드가 끝나면 이 메서드의 지역변수는 메모리에서 사라진다.
}
