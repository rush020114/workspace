import java.util.Scanner;

public class IF_실습3_1 {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int cnt = 0;
    int ones = num % 10;
    int tens = num / 10;
    if(ones == 3 || ones == 6 || ones == 9){
      cnt++;
    }
    if (tens == 3 || tens == 6 || tens == 9) {
      cnt++;
    }
    if(cnt == 2){
      System.out.println("박수짝짝");
    }
    if (cnt == 1) {
      System.out.println("박수짝");
    }
  }
}
