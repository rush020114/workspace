package grade03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * @formatter:on
 * BufferedReader, BufferedWriter를 이용한 빠른 입출력 소스
 * @formatter:off
 */
public class Main03_06 {

  public static void main(String[] args) throws Exception {
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());
    for(int test = 0 ; test < T ; test++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      bw.write(A + B + "\n"); // "\n" 대신에 bw.newLine(); 을 쓸 수도 있습니다.
    }

    bw.flush();
    bw.close();
    br.close();
  }

}