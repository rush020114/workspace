package example;

public class MyArray implements ArrayUtil{

  // 매개변수로 전달되는 배열의 모든 요소의 합을 리턴
  @Override
  public int getSumOfArray(int[] arr) {
    int sum = 0;
    for(int i = 0 ; i < arr.length ; i++){
      sum += arr[i];
    }
    return sum;
  }

  // 매개변수로 전달되는 두 배열의 모든 요소의 평균을 리턴
  @Override
  public double getAvgOfArray(int[] arr1, int[] arr2) {
    return (getSumOfArray(arr1) + getSumOfArray(arr2)) / (double)(arr1.length + arr2.length);
  }

  // 매개변수로 전달되는 배열에서 짝수만을 요소로 갖는 배열을 리턴
  @Override
  public int[] getArrayOfEven(int[] arr) {
    int cnt = 0;
    for(int e : arr){
      if(e % 2 == 0){
        cnt++;
      }
    }
    int[] newArr = new int[cnt];
    int index = 0;
    for(int i = 0 ; i < arr.length ; i++){
      if(arr[i] % 2 == 0){
        newArr[index++] = arr[i];
      }
    }
    return newArr;
  }
}
