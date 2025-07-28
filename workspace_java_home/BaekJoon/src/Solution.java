class Solution {
  public int solution(int[] numbers) {
    int index = 0;
    int[] newNumbers = new int[numbers.length * numbers.length - 1];
    for(int i = 0 ;  i < numbers.length ; i++){
      for(int j = 0 ; j < i ; j++){
        newNumbers[index++] = numbers[i] * numbers[j];
      }
    }
    int max = newNumbers[0];
    if(numbers[0] * numbers[1] < 0){
      max = numbers[0] * numbers[1];
    }
    for(int i = 0 ; i < newNumbers.length ; i++){
      if(max < newNumbers[i]){
        max = newNumbers[i];
      }
    }
    return max;
  }
}