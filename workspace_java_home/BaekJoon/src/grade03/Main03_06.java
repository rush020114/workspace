package grade03;

import java.io.*;
import java.util.StringTokenizer;

public class Main03_06 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer s; // 입력받은 문자열을 토큰화할 수 있는 자료형

    // readLine은 엔터치기 전까지 유지
    int i = Integer.parseInt(br.readLine()); // 버퍼는 문자열을 반환하므로 반복문 돌릴 횟수를 정수에 저장

    for(int j = 0 ; j < i ; j++){
      s = new StringTokenizer(br.readLine()); // 문자열 토큰화될 때까지 대기
      int a = Integer.parseInt(s.nextToken()); // 매개변수가 없으므로 공백을 기준으로 저장
      int b = Integer.parseInt(s.nextToken());

      bw.write(a + b + "\n"); // 출력 버퍼에 저장
    }

    br.close();
    bw.flush(); // 버퍼의 모든 데이터 출력
    bw.close();
  }

}