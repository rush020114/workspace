class Solution {
  public long solution(String numbers) {
    String num = "";
    int index = 0;
    for(int i = 0 ; i < numbers.length() ; i += index){
      System.out.println(numbers.length());
      System.out.println(index);
      if(numbers.substring(index).contains("one")){
        index += 3;
        num += 1;
        continue;
      }

      if(numbers.substring(index).contains("two")){
        index += 3;
        num += 2;
        continue;
      }

      if(numbers.substring(index).contains("three")){
        index += 5;
        num += 3;
        continue;
      }

      if(numbers.substring(index).contains("four")){
        index += 4;
        num += 4;
        continue;
      }

      if(numbers.substring(index).contains("five")){
        System.out.println("five");
        index += 4;
        num += 5;
        continue;
      }

      if(numbers.substring(index).contains("six")){
        System.out.println("six");
        index += 3;
        num += 6;
        continue;
      }

      if(numbers.substring(index).contains("seven")){
        index += 5;
        num += 7;
        continue;
      }

      if(numbers.substring(index).contains("eight")){
        index += 5;
        num += 8;
        continue;
      }

      if(numbers.substring(index).contains("nine")){
        index += 4;
        num += 9;
        continue;
      }

      if(numbers.substring(index).contains("zero")){
        index += 4;
        num += 0;
      }
    }

    return Long.parseLong(num);
  }
}