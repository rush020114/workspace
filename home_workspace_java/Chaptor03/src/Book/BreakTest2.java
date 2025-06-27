public class BreakTest2 {
  public static void main(String[] args) {
    for(int i = 0 ; i < 10 ; i++){
      for(int j = 0 ; j <= i ; j++){
        System.out.print("*");
      }
      System.out.println();
    }
    for(int k = 0 ; k < 10 ; k++){
      for(int l = 0 ; l < 10 ; l++){
        if(k < l){ // l이 k보다 커지면 가장 가까운 반복문을 빠져나와라
          break;
        }
        System.out.print("*");
      }
      System.out.println();
    }
  }
}
