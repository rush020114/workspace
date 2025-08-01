class Solution {
  public String solution(int age) {
    String answer = "";
    int cnt = 0;
    while(true){
      if(age / Math.pow(10, ++cnt) < 1){
        break;
      }
    }
    for(int i = cnt - 1 ; i >= 0 ; i--){
      answer += (char)(age / Math.pow(10, cnt) % 10 + 'a');
      System.out.println(age / Math.pow(10, cnt) % 10);
    }
    return answer;
  }
}