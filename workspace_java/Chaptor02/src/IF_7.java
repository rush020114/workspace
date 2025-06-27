public class IF_7 {
  public static void main(String[] args){
    // 문자열을 if조건문에 넣을 수 있는 방법
    String name = "홍길동";

    // 문자열 비교는 equals() 명령어를 사용한다.
    if(name.equals("홍길동")){
      System.out.println("A");
    }

    // "java"를 A, ".equals("java")"를 B라 할 때
    // B 안의 문자열이 A와 같으면 true를 반환
    System.out.println("java".equals("java"));
    System.out.println("java".equals("Java")); // 문자열이 다르므로 false

    String str1 = "java";
    System.out.println(str1.equals("java")); // str1의 문자열과 "java"의 문자열이 같다라는 문장, 같으므로 true
    String str2 = "python";
    System.out.println(str1.equals(str2)); // str1의 문자열과 str2의 문자열이 같다라는 문장, 같지 않으므로 false
  }
}
