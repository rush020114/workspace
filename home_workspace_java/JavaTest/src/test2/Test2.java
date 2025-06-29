package test2;

public class Test2 {
  public static void main(String[] args){
    int[] numArr = new int[6];
    for(int i = 0 ; i < numArr.length ; i++){
      int randomNum = (int)((Math.random() * 45) + 1);
      numArr[i] = randomNum;
    }

    for(int e : numArr){
      System.out.println(e);
    }
  }
}
