package academy;
// 3, 6, 9 배열 문제
public class ArrayExample02 {
  public static void main(String[] args) {
    // 배열 99개 형성
    // 만약 10의 자리가 3, 6, 9이면 cnt+1, 그리고 1의 자리가 3, 6, 9이면 cnt+1
    // cnt + 1할 때 변수 / 10한 변수와 변수 % 10한 변수가 3의 배수이되 0이면 안 된다.
    // 전부 아니면 continue
    // continue에 해당 안 되면서 만약 cnt가 2개이면 짝짝 cnt가 하나이면 짝(continue문 뒤에 써야 할 듯)
    int[] arr = new int[99];
    int cnt = 0;
    for(int i = 0 ; i < arr.length ; i++){
      cnt = 0;
      arr[i] = i + 1;
      int tens = arr[i] / 10;
      int ones = arr[i] % 10;
      if(tens % 3 == 0 && tens != 0){
        cnt++;
      }
      if(ones % 3 == 0 && ones != 0){
        cnt++;
      }
      if(cnt == 1){
        System.out.println(arr[i] + " 박수짝");
      }
      else if(cnt == 2){
        System.out.println(arr[i] + " 박수짝짝");
      }

    }
  }
}
