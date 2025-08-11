class Solution {
  public String[] solution(String my_str, int n) {
    int length = my_str.length() % n == 0 ? my_str.length() / n : my_str.length() / n + 1;
    String[] answer = new String[length];
    for(int i = 0 ; i < answer.length ; i++){
      if(i == answer.length - 1){
        answer[i] = my_str.substring(i * n, i * n + my_str.length() % n);
        break;
      }
      System.out.println(my_str.substring(i * n, i * n + n));
      answer[i] = my_str.substring(i * n, i * n + n);
    }

    return answer;
  }
}