package 이론;

public class 메서드_배열 {
  public static void main(String[] args){
    int[] arr = new int[3]; // 배열을 호출하기 위한 배열 미리 생성
    printArr(arr); // 미리 생성한 뒤 배열의 호출
  }

  // 지금의 메서드는 정수형 배열을 매개변수로 기능하는 메서드이다. 그러니 호출하려면 매개변수에 정수형 배열 데이터를 넣어줘야 한다.
  public static void printArr(int[] arr){ // 호출했기 때문에 매개변수에 arr이 저장
    for(int i = 0 ; i < arr.length ; i++){
      arr[i] = i + 1;
      System.out.println(arr[i]);
    }
  }
}
