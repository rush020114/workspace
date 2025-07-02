package book;

public class ArrayTest5 {
  public static void main(String[] args) {
    // 배열 안의 저장공간에 더 작은 범위의 자료형이 들어가면 자동 형변환된다.
    double[] scoreList = {76, 92.4, 49, 78.3, 83.7};
    System.out.println(scoreList.length + "개의 점수 현황");
    for(int i = 0; i < scoreList.length ; i++){
      System.out.println("scoreList[" + i + "] : " + scoreList[i]);
    }
  }
}
