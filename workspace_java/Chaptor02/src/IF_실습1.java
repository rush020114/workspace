import java.util.Scanner;

public class IF_실습1 {
  public static void main(String[] args){
    System.out.println("1번");

    int num1, num2;
    num1 = 20;
    num2 = 30;
    if (num1 + num2 > 50) { // 두 변수의 합이 50보다 크면 밑의 문장을 출력하겠다.
      System.out.println("두 수의 합이 50보다 큽니다.");
    }

    else { // 두 변수의 합이 50이하이면 밑의 문장을 출력하겠다.
      System.out.println("두 수의 합이 50이하입니다.");
    }

    System.out.println("2번");

    Scanner sc = new Scanner(System.in);
    System.out.print("정수 입력 : ");
    int num = sc.nextInt();

    if ((num % 2) == 0) { // 만약에 입력받은 값이 짝수라면
      System.out.println("짝수입니다.");
    }

    else if ((num % 2) != 0) { // 홀수이면..
      System.out.println("홀수입니다.");
    }

    else { // 0이면
      System.out.println("0");
    }

    System.out.println("3번");

    System.out.print("a 입력 : ");
    int a = sc.nextInt();
    System.out.print("b 입력 : ");
    int b = sc.nextInt();

    if (a > b) { // a가 b보다 크면
      System.out.println("a가 큽니다.");
    }

    else if (a < b) { // 그렇지 않고 만약 b가 a보다 크면
      System.out.println("b가 큽니다.");
    }

    else { // 그렇지 않다면(a와 b가 같으면)
      System.out.println("두 수가 같습니다.");
    }

    System.out.println("4번");

    int three;
    System.out.print("3의 배수 : ");
    three = sc.nextInt();
    if (three % 3 == 0) { // three가 3의 배수라면...
      System.out.println("3의 배수입니다.");
    }

    System.out.println("5번");

    int score;
    System.out.print("학점(0~100) : ");
    score = sc.nextInt();

    // 학점(A,B,C) 데이터를 저장하는 변수
    // 밑의 코드처럼 작성하면 중복을 최소화할 수 있다.
    String grade = "";

    if (score > 90 && score <= 100) { // 90보다 크고 100보다 크지 않다면
      grade = "A";
    }

    else if (score > 80) { // 80보다 크고 90보다 크지 않다면
      grade = "B";
    }

    else{ // 나머지
      grade = "C";
    }
    System.out.println("학점은 " + grade + "입니다.");

    System.out.println("6번");

    int five;
    System.out.print("5의 배수가 아닌 것 : ");
    five = 5;
    if (five % 5 != 0) {
      System.out.println("5의 배수를 입력하세요.");
    }

    System.out.println("7번");
    System.out.println("B");

    System.out.println("8번");
    System.out.println("A");
    System.out.println("B");
    System.out.println("D");
    System.out.println("H");

    System.out.println("9번");

    int first1, second1;
    System.out.println("두 수의 크기 비교");
    System.out.print("첫번째 수 : ");
    first1 = sc.nextInt();
    System.out.print("두번째 수 : ");
    second1 = sc.nextInt();

    // min : 작은 값을 저장할 변수
    // max : 큰 값을 저장할 변수
    int min, max;

    if (first1 > second1) {// first1이 second1보다 큰 경우를 가정.
      max = a;
      min = b;
    }
    else { // second1이 first1보다 큰 경우를 가정.
      max = b;
      min = a;
    }
    System.out.println(max + ">" + min);


    System.out.println("10번");

    int first2, second2, third2;
    System.out.print("첫번째 수 : ");
    first2 = sc.nextInt();
    System.out.print("두번째 수 : ");
    second2 = sc.nextInt();
    System.out.print("세번째 수 : ");
    third2 = sc.nextInt();

    if (first2 > second2 && second2 > third2) {
      System.out.println(first2 + " > " + second2 + " > " + third2);
    }

    else if (first2 > third2 && third2 > second2) {
      System.out.println(first2 + " > " + third2 + " > " + second2);
    }

    else if (second2 > first2 && first2 > third2) {
      System.out.println(second2 + " > " + first2 + " > " + third2);
    }

    else if (second2 > third2 && third2 > first2) {
      System.out.println(second2 + " > " + third2 + " > " + first2);
    }

    else if (third2 > first2 && first2 > second2) {
      System.out.println(third2 + " > " + first2 + " > " + second2);
    }

    else if (third2 > second2 && second2 > first2) {
      System.out.println(third2 + " > " + second2 + " > " + first2);
    }

  }
}
