public class ArrayTest4 {
  public static void main(String[] args) {
    // 배열은 생성되는 순간 저장할 수 있는 배열의 요소들의 개수가 결정된다.
    // 만약 생성되지 않은 배열의 요소를 사용하려 하면 오류가 생긴다.(만약 배열에 저장된 공간이 5개인데 5번째 요소를 사용하려 하면 오류가 생긴다.
    // 자바는 이런 문제를 해결하기 위해 배열의 크기에 대한 변수를 제공한다.(변수.length)
    // length변수보다 1작을 때까지 반복문을 실행하면 배열의 저장공간 개수가 바뀌어도 length변수가 함께 바뀌므로 문제 없다.
    int[] scoreList = {76, 92, 49, 83, 100};
    System.out.println(scoreList.length + "개의 점수 현황"); // length변수이므로 배열의 저장공간이 바뀌어도 문제 없음.

    for(int i = 0; i < scoreList.length ; i++){
      System.out.println("scoreList[" + i + "] : " + scoreList[i]);
    }
  }
}
