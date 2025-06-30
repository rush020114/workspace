package academy;

public class MethodExample02 {
  public static void main(String[] args){
    int[] sumArr1 = {1, 3, 5, 7, 9}; // 배열을 호출하기 위해 미리 작성한 정수형 배열
    int[] sumArr2 = {2, 4, 6, 8, 10}; // 기능을 구현하기 위해 필요한 매개변수가 두개이므로 한 개 더 생성
    System.out.println(newArr(sumArr1, sumArr2)); // newArr에 두 정수형 배열을 전달하며 호출
    for(int i = 0 ; i < sumArr1.length + sumArr2.length ; i++){
      System.out.print(newArr(sumArr1, sumArr2)[i]);// newArr(sumArr1, sumArr2)이 곧 정수형 배열을 의미하므로 뒤에 [정수]가 붙으면 요소출력 가능
    }
  }

  public static int[] newArr(int[] arr1, int[] arr2){ // 매개변수 각각은 sumArr1과 sumArr2를 받음.
    int newArr[] = new int[arr1.length + arr2.length];
    for(int i = 0 ; i < arr1.length ; i++){
      newArr[i] = arr1[i];
    }
    for(int i = arr1.length ; i < arr1.length + arr2.length ; i++){
      newArr[i] = arr2[i - arr1.length];
    }
    return newArr; // 리턴타입이 정수형 배열이므로 정수형 배열 리턴
  }
}
