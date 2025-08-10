class Solution {
  public int solution(String s) {
    int index = 0;
    int answer = 0;
    for(int i = 0 ; i < s.length() / 2 + 1 ; i++){
      if(s.charAt(index) == 90){
        index -= 2;
        answer -= s.charAt(index) - '0';
        System.out.println(answer);
        index += 4;
        continue;
      }
      answer += s.charAt(index) - '0';
      System.out.println(answer);
      index += 2;
    }
    return answer;
  }
}