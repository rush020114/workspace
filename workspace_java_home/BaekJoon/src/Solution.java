import java.util.Arrays;

class Solution {
  public int solution(int[] array, int n) {
    int[] newArr1 = new int[array.length];
    int[] newArr2 = new int[array.length];
    int[] cntArr = new int[2];
    int index = 0;
    int result = 0;
    for(int i = 0 ; i < array.length ; i++){
      newArr1[i] = Math.abs(n - array[i]);
      newArr2[i] = Math.abs(n - array[i]);
    }
    for(int i = 0 ; i < newArr1.length - 1 ; i++){
      for(int j = 0 ; j < newArr1.length - (i + 1) ; j++){
        if(newArr2[j] > newArr2[j + 1]){
          int temp = newArr2[j];
          newArr2[j] = newArr2[j + 1];
          newArr2[j + 1] = temp;
        }
      }
    }

    if(array.length != 1){
      if(newArr2[0] == newArr2[1]){
        for(int i = 0 ; i < newArr1.length ; i++){
          boolean isDup = false;
          if(newArr2[0] == newArr1[i]){
            isDup = true;
          }
          if(isDup){
            cntArr[index++] = i;
          }
        }
        result = Math.min(array[cntArr[0]], array[cntArr[1]]);
      }
      else{
        for(int i = 0 ; i < newArr1.length ; i++){
          boolean isDup = false;
          if(newArr2[0] == newArr1[i]){
            isDup = true;
          }
          if(isDup){
            index = i;
          }
        }
        result = array[index];
      }
    }
    else{
      result = array[0];
    }

    return result;
  }
}