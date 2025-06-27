public class ArrayTest2 {
  public static void main(String[] args) {

    int[] scoreList = new int[5];
    scoreList[0] = 76;
    scoreList[1] = 92;
    scoreList[2] = 49;
    System.out.println("scoreList[0] : " + scoreList[0]); // 0번째 요소에 76을 저장했으므로 76
    System.out.println("scoreList[1] : " + scoreList[1]); // 1번째 요소에 92를 저장했으므로 92
    System.out.println("scoreList[2] : " + scoreList[2]); // 2번째 요소에 49를 저장했으므로 49
    System.out.println("scoreList[3] : " + scoreList[3]); // 기본값이므로 0
    System.out.println("scoreList[4] : " + scoreList[4]); // 기본값이므로 0
  }
}
