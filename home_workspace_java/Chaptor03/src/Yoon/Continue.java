public class Continue {
  public static void main(String[] args) {
    int i = 0;
    int count = 0;
    while (i++ < 100) { // ++이 뒤에 쓰였으므로 실행 후 1 증가
      // if문 안에 i++이 쓰이면 35가 되면 if문을 읽지 않으므로 35에서 무한반복
      if (i % 5 != 0 || i % 7 != 0) {
        continue; // 5의 배수와 7의 배수가 아니라면 밑의 문장들을 건너뛰겠다.
      }
      // if문 뒤에 i++이 쓰이면 continue때문에 if 뒤의 문장을 건너뛰어 i를 증가시키지 못함
      System.out.println(i); // 5의 배수이면서 7의 배수이면 이 문장을 실행하겠다.
      count++; // 5의 배수이면서 7의 배수이면 이 문장을 실행하겠다.
    }
    System.out.println("count = " + count);

    int cnt = 0;
    for(int j = 1 ; j < 100 ; j++){
      if (j % 5 != 0 || j % 7 != 0) {
        continue;
      }
      System.out.println(j);
      cnt++;
    }
    System.out.println(cnt);
  }
}
