public class ArrayTest1 {
  public static void main(String[] args) {
    // 배열 : 배열은 참조자료형이며 동일한 자료형을 한 데 모아 처리하는 목적을 갖는다.
    // 배열은 생성 시 각 저장 공간에 자동으로 기본값이 저장된다.(정수는 0 실수는 0.0 논리는 false)
    // 배열의 생성은 new 자료형[배열의 크기]
    // 배열을 생성하기 위한 배열의 변수를 선언하는 문법 : 자료형[] 변수; <- 여기서 자료형은 완전히 새로운 자료형이다.
    // []가 있으면 현재의 변수가 배열임을 의미한다.
    int score = 83;
    int[] scoreList = new int[5];
    System.out.println("기본형 score : " + score);
    System.out.println("참조형 scoreList : " + scoreList);

  }
}
