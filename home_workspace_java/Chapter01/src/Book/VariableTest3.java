public class VariableTest3 {
  public static void main(String[] args){
    //변수에 할당된 값을 서로 교환하는 프로그램
    System.out.println("[ 교환 전 ]");
    int javaScore = 83;
    int pythonScore = 100;
    System.out.println("javaScore : " + javaScore);
    System.out.println("pythonScore : " + pythonScore);

    System.out.println("----------------");
    int temp; // javaScore를 넣을 값을 변수 선언
    temp = javaScore; // javaScore 값 저장
    javaScore = pythonScore; // pythonScore값 javaScore에 저장
    pythonScore = temp; // temp에 저장되었던 javaScore값 pythonScore에 저장
    System.out.println("[ 교환 후 ]"); // 이러면 교환 전 저장된 값이 변경되면 따라 변경됨.
    System.out.println("javaScore : " + javaScore);
    System.out.println("pythonScore : " + pythonScore);
  }
}
