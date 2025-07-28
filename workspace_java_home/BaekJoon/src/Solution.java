class Solution {
  public int solution(String str1, String str2) {
    int answer = 0;
    for(int i = 0 ; i <= str1.length() - str2.length() ; i++){
      if(str1.substring(i, i + str2.length()).equals(str2)){
        System.out.println(str1.substring(i, i + str2.length()));
        answer = 1;
        break;
      }
      else{
        answer = 2;
      }
    }
    return answer;
  }
}