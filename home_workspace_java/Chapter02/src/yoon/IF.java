public class IF {
  public static void main(String[] args){
    int n1 = 5;
    int n2 = 7;

    // if문
    // if문은 소괄호 안에 true 혹은 false가 반환되는 문장이 들어가야 한다.
    // if문의 괄호 안의 문장은 소괄호가 true일 때 실행된다.
    if(n1 < n2){
      System.out.println("n1 > n2 is true");
    }

    // if, else문
    // if, else문일 때 else문은 if의 값이 false일 때 실행된다.

    if (n1 == n2) { // if문이 false이므로 else문 실행
      System.out.println("n1 = n2 is true");
    }


    else {
      System.out.println("n1 = n2 is false");
    }

    // if, else if, else문
    // if와 else 안에 else if가 개수에 상관없이 들어갈 수 있다.
    // if문이 거짓이면 순차적으로 다음 문장의 참/거짓을 판단한다.
    int num = 120;

    if (num < 0) { // if문이 거짓이므로 else if문의 조건으로 넘어간다.
      System.out.println("0 미만");
    }
    else if(num < 100){ // else if문이 거짓이므로 else문의 조건으로 넘어간다.
      System.out.println("0 이상 100 미만");
    }
    else{ // 위의 모두가 거짓이면 else는 참일 수밖에 없으므로 코드 실행
      System.out.println("100 미만");
    }

  }
}
