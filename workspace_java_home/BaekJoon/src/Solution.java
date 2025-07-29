class Solution {
  public int solution(int num, int k) {
    int cnt = 0;
    int index = 0;
    int answer = 0;

    while(true){
      if(num / Math.pow(10, index++) < 1){
        break;
      }
      cnt++;
    }
    for(int i = cnt - 1 ; i > -1 ; i--){
      int newNum = (num / (int)(Math.pow(10, i))) % 10;
      System.out.println(newNum);
      if(newNum == k){
        answer = i + 1;
        break;
      }
      else{
        answer = -1;
      }
    }
    return answer;
  }
}