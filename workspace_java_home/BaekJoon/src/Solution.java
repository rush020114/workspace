class Solution {
  public String solution(String bin1, String bin2) {
    String answer = "";
    for(int i = 0 ; i < bin1.length() ; i++){
      if(bin1.substring(0, 1).equals("1") && bin2.substring(0, 1).equals("1")){
        answer += "1";
      }
        switch(Integer.parseInt(bin1.substring(i, i + 1)) + Integer.parseInt(bin2.substring(i, i + 1))){
          case 0:
            answer += "0";
            break;
          case 1:
            answer += "1";
            break;
          default:
            answer += "0";
        }
    }
    return answer;
  }
}