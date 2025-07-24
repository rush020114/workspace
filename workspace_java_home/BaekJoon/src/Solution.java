class Solution {
  int numer1;
  int denom1;
  int numer2;
  int denom2;
  public int[] solution(int numer1, int denom1, int numer2, int denom2) {
    int cnt = 0;
    int index = 0;
    int d1 = 0;
    int d2 = 0;
    int[] answer = new int[2];
    for(int i = 1 ; i <= denom1 ; i++){
      if(denom1 % i == 0){
        cnt++;
      }
    }
    int[] denomArr1 = new int[cnt];
    for(int i = 1 ; i <= denom1 ; i++){
      if(denom1 % i == 0){
        denomArr1[index++] = i;
      }
    }
    cnt = 0;
    index = 0;
    for(int i = 1 ; i <= denom2 ; i++){
      if(denom2 % i == 0){
        cnt++;
      }
    }
    int[] denomArr2 = new int[cnt];
    for(int i = 1 ; i <= denom2 ; i++){
      if(denom1 % i == 0){
        denomArr2[index++] = i;
      }
    }

    for(int i = 0 ; i < denomArr1.length ; i++){
      for(int j = 0 ; j < denomArr2.length ; j++){
        if(denom1 * denomArr1[i] == denom2 * denomArr2[j] && denomArr1[i] * denomArr2[j] != 1){
          d1 = denomArr1[i]; // 2
          d2 = denomArr2[j]; // 1
          answer[1] = d1 * denom1;
          answer[0] = d1 * numer1 + d2 * numer2;
          break;
        }

        else{
          answer[1] = denom1 * denom2;
          answer[0] = numer1 * denom2 + numer2 * denom1;
          break;
        }
      }
    }

    return answer;
  }
}
