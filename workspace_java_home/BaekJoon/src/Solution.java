class Solution {
  public int solution(int[] array) {
    int index = 0;
    for(int i = 0 ; i < array.length ; i++){
      int cnt = 0;
      for(int j = 0 ; j < i ; j++){
        if(array[i] == array[j]){
          cnt++;
        }
      }
      if(cnt == 0){
        index++;
      }
    }
    int[] newArr = new int[index];
    int[] maxes = new int[index];
    index = 0;
    for(int i = 0 ; i < array.length ; i++){
      int cnt = 0;
      for(int j = 0 ; j < i ; j++){
        if(array[i] == array[j]){
          cnt++;
        }
      }
      if(cnt == 0){
        newArr[index++] = array[i];
      }
    }
    index = 0;
    for(int i = 0 ; i < newArr.length ; i++){
      int cnt = 0;
      for(int j = 0 ; j < array.length ; j++){
        if(newArr[i] == array[j]){
          cnt++;
        }
      }
      maxes[index++] = cnt;
    }
    int max = -1;
    index = 0;
    for(int i = 0 ; i < newArr.length ; i++){
      if(max < maxes[i]){
        max = maxes[i];
        index = i;
      }
    }
    for(int i = 0 ; i < newArr.length - 1 ; i++){
      for(int j = 0 ; j < newArr.length - (i + 1) ; j++){
        if(maxes[j] > maxes[j + 1]){
          int temp = maxes[j];
          maxes[j] = maxes[j + 1];
          maxes[j + 1] = temp;
        }
      }
    }
    int answer;
    if(array.length == 1){
      answer = array[0];
    }
    else if(newArr.length == 1){
      answer = -1;
    }
    else{
      if(maxes[maxes.length - 1] == maxes[maxes.length - 2]){
        answer = -1;
      }
      else{
        answer = newArr[index];
      }
    }
    return answer;
  }
}