package book;

public class ArrayTest06 {
  public static void main(String[] args) {
    int[] scoreList = {76, 92, 49, 83, 78};
    int sum = 0;
    int max = scoreList[0]; // 배열의 첫시작부터 최대/최소를 판별해도 성립한다.
    int min = scoreList[0];
    for(int i = 0 ; i < scoreList.length ; i++){
      if (max < scoreList[i]) { // 배열에서 꺼낸 점수가 max보다 크면
        max = scoreList[i]; // max에 꺼낸 점수를 저장하여서 최댓값을 만들겠다.
      }
      if (min > scoreList[i]) {
        min = scoreList[i];
      }
      sum = sum + scoreList[i];
    }
    System.out.println("최고 점수 : " + max);
    System.out.println("최저 점수 : " + min);
    System.out.println("최저 총합 : " + sum);
    System.out.println("최저 총합 : " + (sum / (double)scoreList.length));
  }
}
