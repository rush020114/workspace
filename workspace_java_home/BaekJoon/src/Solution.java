
class Solution {
  public int[] solution(int n) {
    int cnt = 0;
    int index = 0;
    for(int i = 0 ; i < n ;i ++){
      if(n % (i + 1) == 0){
        cnt++;
      }
    }
    int[] ints = new int[cnt];
    for(int i = n - 1 ; i >= 0 ; i--){
      if(n % (i + 1) == 0){
        ints[index++] = n / (i + 1);
      }
    }
    index = 0;
    for(int i = 0 ; i < ints.length ; i++){
      cnt = 0;
      for(int j = 1 ; j <= ints[i] ; j++){
        if(ints[i] % j == 0){
          cnt++;
        }
      }
      if(cnt == 2){
        index++;
      }
    }
    int[] newInts = new int[index];
    index = 0;
    for(int i = 0 ; i < ints.length ; i++){
      cnt = 0;
      for(int j = 1 ; j <= ints[i] ; j++){
        if(ints[i] % j == 0){
          cnt++;
        }
      }
      if(cnt == 2){
        newInts[index++] = ints[i];
      }
    }
    return newInts;
  }
}