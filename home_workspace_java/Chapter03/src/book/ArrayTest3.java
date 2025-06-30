public class ArrayTest3 {
  public static void main(String[] args) {
    int[] scoreList = {76, 92, 49, 83, 100};
    for(int i = 0 ; i < 5 ; i++){
      System.out.println("scoreList[" + i + "] : " + scoreList[i]);
    }
    // for each문 배열에 저장된 수를 차례차례 반복하여 저장한다.
    // for each문 문법 : for(자료형 변수 : 배열의 변수)
    for(int score : scoreList){
      System.out.println("score : " + score);
    }
  }
}
