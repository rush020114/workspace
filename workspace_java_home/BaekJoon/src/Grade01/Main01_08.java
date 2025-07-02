import java.util.Scanner;

public class Main01_08 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int y = sc.nextInt();
    if (y >= 1000  && y <= 3000) {
      System.out.println(y - 543);
    }
  }
}
