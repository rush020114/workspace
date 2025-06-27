package Academy;

public class MethodExample01 {
  public static void main(String[] args){
    String[] foodArr = {"피자", "치킨", "햄버거"};
    System.out.println(arrList(foodArr)); // arrlist에 정수형 배열을 전달하며 호출(리턴타입은 문자열이고 리턴이 sum이므로 sum을 출력)
  }
  public static String arrList(String[] arr){ // 메서드 작성 땐 괄호 안의 값이 있다고 판단하고 작성
    String sum = "";
    for(int i = 0 ; i < arr.length ; i++){ // 문자열을 나열할 기능
      sum = sum + arr[i] + " ";
    }
    return sum;
  }
}
