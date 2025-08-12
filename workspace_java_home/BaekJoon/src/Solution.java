import java.util.Arrays;

class Solution {
  public int solution(int[] array, int n) {
    int[] newArr = new int[array.length];
    int index = 0;
    for(int i = 0 ; i < array.length ; i++){
      newArr[i] = Math.abs(n - array[i]);
    }
    System.out.println(Arrays.toString(newArr));
    for(int i = 0 ; i < newArr.length - 1 ; i++){
      for(int j = 0 ; j < newArr.length - (i + 1) ; j++){
        if(newArr[j] > newArr[j + 1]){
          int temp = newArr[j];
          newArr[j] = newArr[j + 1];
          newArr[j + 1] = temp;
        }
      }
    }
    System.out.println(Arrays.toString(newArr));

    return array[index];
  }
}