package 실습;

public class 메서드문제3 {
  public static void main(String[] args){
    System.out.println("구구단 : ");
    gugudan(13);
    System.out.println("지정받은 수의 1~100까지의 배수를 출력 : ");
    drainage(6);
    System.out.print("랜덤한 정수 : ");
    System.out.println(random());
    System.out.print("짝홀 : ");
    System.out.println(evenOdd(2));
    System.out.print("배열의 모든 요소 : ");
    int[] arr1 = {1, 3, 5, 6, 8};
    arrList(arr1);
    System.out.print("배열의 요소 중 최댓값 : ");
    int[] arr2 = {1, 6, 9, 3, 5};
    int max = arrMax(arr2);
    System.out.println(max);
    System.out.println("문자열 배열 나열 : ");
    String[] arr3 = {"아", "에", "이"};
    System.out.println(arrStrList(arr3));
    System.out.print("두 배열을 합친 새로운 배열 : ");
    int[] sumArr1 = {1, 2, 3, 4, 5};
    int[] sumArr2 = {6, 7, 8, 9, 10};
    System.out.print(newArr(sumArr1, sumArr2) + ", ");
    for(int i = 0 ; i < newArr(sumArr1, sumArr2).length ; i++){
      System.out.print(newArr(sumArr1, sumArr2)[i] + " ");
    }
    System.out.println();
    int[] evenArr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    System.out.println(evenArr(evenArr));
    System.out.println(evenArr(evenArr).length);



    System.out.print("두 정수 스위칭 : ");
    switching(10, 20);
  }

  public static void gugudan(int num){
    for(int i = 1 ; i < 10 ; i++){
      System.out.println(num + " * " + i + " = " + (num * i));
    }
  }
  public static void drainage(int num){
    for(int i = 1 ; i < 101 ; i++){
      if(num * i > 100){
        break;
      }
      System.out.print(num * i + " ");
    }
    System.out.println();
  }
  public static int random(){
    int num = (int)((Math.random() * 49) + 1);
    return num;
  }
  public static boolean evenOdd(int num){
    if(num % 2 == 0){
      return true;
    }
    else{
      return false;
    }
  }
  public static void arrList(int[] arr){
    for(int i = 0 ; i < arr.length ; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
  public static int arrMax(int[] arr){
    int max = arr[0];
    for(int i = 0 ; i < arr.length ; i++){
      if (arr[i] > max) {
        max = arr[i];
      }
    }
    return max;
  }
  public static String arrStrList(String[] arr){
    String sum = "";
    for(int i = 0 ; i < arr.length ; i++){
      sum = sum + arr[i];
    }
    return sum;
  }
  public static int[] newArr(int[] arr1, int[] arr2){
    int[] arr12 = new int[arr1.length + arr2.length];
    for(int i = 0 ; i < arr1.length ; i++) {
      arr12[i] = arr1[i];
    }
    for(int i = 0 ; i < arr2.length ; i++){
      arr12[arr1.length + i] = arr2[i];
    }
    return arr12;
  }

  public static int[] evenArr(int[] arr){
    int cnt = 0;
    for(int i = 0 ; i < arr.length ; i++){
      if (arr[i] % 2 == 0) {
        cnt++;
      }
    }
    int[] newEvenArr = new int[cnt];
    return newEvenArr;
  }

  public static void switching(int num1, int num2){
    int num3 = num1;
    num1 = num2;
    num2 = num3;
    System.out.println(num1 + " " + num2);
  }
}
