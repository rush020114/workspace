public class LoopExample01 {
  public static void main(String[] args){
    int cnt = 0;
    for(int i = 2 ; i < 31 ; i++){
      for(int j = 1 ; j <= i ; j++){
        if(i % j == 0){
          cnt++;
        }
      }
      System.out.println(cnt);
      if(cnt >= 3){
        continue;
      }
      System.out.println(i);
    }
  }
}
