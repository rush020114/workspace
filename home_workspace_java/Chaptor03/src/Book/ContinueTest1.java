public class ContinueTest1 {
  public static void main(String[] args) {
    // continue문 : continue문의 조건을 충족하면 아래의 수행문을 한차례 건너뛰어 반복한다.
    for(int i = 1; i < 11 ; i++){
      if(i == 5){ // i가 5가 되면 다음 수행문으로 건너뛰겠다.
        continue;
      }
      System.out.println("i의 값 : " + i);
    }
  }
}
