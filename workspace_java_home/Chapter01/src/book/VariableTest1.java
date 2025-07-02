public class VariableTest1 {
  public static void main(String[] args){
    int javaScore = 83; //변수 javaScore의 정수 형태 선언과 초기화(변수 안에 값을 처음으로 저장)를 동시에
    System.out.println(javaScore);
    javaScore = 0; // 이미 저장된 값이 있는데 다른 값을 저장하면 새로운 값으로 덮어쓰기 된다.
    System.out.println(javaScore);
  }
}
