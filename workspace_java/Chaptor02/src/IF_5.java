public class IF_5 {
  public static void main(String[] args){
    int x = 3;

    if(x > 1) { // x가 1보다 크면
      System.out.println("A");
    }

    else if(x > 5){ // 그렇지 않고 x가 5보다 크면
      System.out.println("B");
    }

    else if(x > 7){ // 그렇지 않고 x가 7보다 크면
      System.out.println("C");
    }

    x = 0;

    // 새로운 if문(위의 if문과는 독립된 코드)
    // else가 없으면 실행이 되지 않을 수도 있다.
    if(x > 1) {
      System.out.println("A");
    }

    else if(x > 5){
      System.out.println("B");
    }

    else if(x > 7){
      System.out.println("C");
    }


  }
}
