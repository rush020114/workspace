// sum에 더해줄 값을 1씩 더해서 누적
package 실습;
public class 반복문문제05 {
  public static void main(String[] args) {
    // 1에서 10까지의 합을 저장한 변수
    int sum = 0; // 더해진 값
    int i = 1; // 더해줄 값 (1씩 증가)
    while (i < 11) {
      sum = sum + i; // 더해진 값에 더해줄 값을 저장
      i++;
    }

    System.out.println(sum);
  }
}
