package academy;

public class MethodExample03 {
  public static void main(String[] args){
    int[] evenArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(newArr(evenArr)); // 메서드 호출 시엔 매개변수 정보를 적는 것이 중요.(메서드 호출 후 리턴값 출력)
  }

  public static int[] newArr(int[] arr){ // 호출 후 arr은 evenArr이 됨.
    int cnt = 0;
    for(int i = 0 ; i < arr.length ; i++){
      if(arr[i] % 2 == 0){
        System.out.println(arr[i]);
        cnt++;
      }
    }
    System.out.println(cnt);
    int[] newArr = new int[cnt];
    return newArr; // 리턴타입이 정수형 배열이므로 정수형배열 리턴
  }
}
