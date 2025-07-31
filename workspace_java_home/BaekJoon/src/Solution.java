class Solution {
  public int solution(String my_string) {
    int[] ints = new int[9];
    String[] strings = new String[9];
    int cnt = 0;
    int index = 0;
    int answer = 0;
    for(int i = 0 ; i < ints.length ; i++){
      ints[i] = i + 1;
      strings[i] = String.valueOf(ints[i]);
    }
    for(int i = 0 ; i < ints.length ; i++){
      for(int j = 0 ; j < my_string.length() ; j++){
        if(strings[i].equals(my_string.substring(j, j + 1))){
          cnt++;
        }
      }
    }
    String[] newStrings = new String[cnt];
    for(int i = 0 ; i < ints.length ; i++){
      for(int j = 0 ; j < my_string.length() ; j++){
        if(strings[i].equals(my_string.substring(j, j + 1))){
          newStrings[index++] = strings[i];
        }
      }
    }
    for(int i = 0 ; i < newStrings.length ; i++){
      answer += Integer.parseInt(newStrings[i]);
    }
    return answer;
  }
}