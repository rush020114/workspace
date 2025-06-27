public class ForTest2 {
  public static void main(String[] args) {
    // for문을 중첩해서 할 수도 있다.
    int dan1 = 2;
    for(int i = 1 ; i < 10 ; i++){
      System.out.println(dan1 + " X " + i + " = " + (dan1 * i));
    }

    for(int j = 2 ; j < 10 ; j++){
      System.out.println("== " + j + "단 ==");
      for(int k = 1 ; k < 10 ; k++){
        System.out.println(j + " X " + k + " = " + (j * k));
      }
    }
  }
}
