package grade04;

public class Main04_08 {
  public static void main(String[] args){
    int n = 930211;
    int cnt = 0;
    int index = 1;
    int sum =0;
    while(true){
      cnt++;
      if(n / index <= 0){
        break;
      }
      index *= 10;
    }
    System.out.println(cnt);
    for(int i = 0 ; i < cnt ; i++){

    }
  }
}
