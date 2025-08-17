class Solution {
  public int solution(String s) {
    String[] strings = s.split(" ");
    int index = 0;
    int cnt = 0;
    for(int i = 0 ; i < strings.length ; i++){
      if(strings[i].equals("Z")){
        cnt++;
      }
    }
    int[] ints = new int[cnt * 2];
    for(int i = 0 ; i < strings.length ; i++){
      if(strings[i].equals("Z")){
        ints[index++] = i - 1;
        ints[index++] = i;
      }
    }
    int sum = 0;
    index = 0;
    if(ints.length != 0){
      for(int i = 0 ; i < strings.length ; i++){
        if(ints[index] == i){
          if(!(index == ints.length - 1)){
            index++;
          }
          continue;
        }
        sum += Integer.parseInt(strings[i]);
      }
    }
    else{
      for(int i = 0 ; i < strings.length ; i++){
        sum += Integer.parseInt(strings[i]);
      }
    }
    return sum;
  }
}