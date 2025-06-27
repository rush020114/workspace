package 이론;

public class Break_Continue_1 {
  public static void main(String[] args) {
    // break : 반복문을 벗어나게 해준다.(가장 가까운 반복문)
    for(int i = 0 ; i < 5 ; i++){
      if(i == 3){
        break;
      }
      System.out.println(i);
    }

    // continue : 해당회차만 중지하고 가장 가까운 반복문의 다음 회차를 실시
    for(int j = 0 ; j < 5 ; j++){
      if (j == 3) {
        continue;
      }
      System.out.println(j);
    }
  }
}
