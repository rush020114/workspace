public class CastingTest1 {
  public static void main(String[] args){
    // 강제 형변환(Casting) : 큰 데이터를 작은 데이터로 강제 변환(데이터 손실이 발생)
    double doubleAvg = 87.24;
    int intAvg = (int)doubleAvg; // 더 큰 double데이터를 더 작은 int 데이터로 강제 형변환시켜 저장
    System.out.println(intAvg); // 강제형변환 과정에서 데이터 손실

    char charA = 'A';
    int intA = charA; // 작은 데이터 문자타입을 큰 데이터 정수타입에 저장하면서 자동형변환이 일어남
    System.out.println("문자A(char) -> 정수(int) : " + intA); // 문자가 정수로 변환되어 출력

    int intZ = 90;
    char charZ = (char)intZ; // 큰 데이터 정수타입을 작은 데이터 문자로 강제 형변환시켜 문자타입에 저장
    System.out.println("정수90(int) -> 문자Z(char) : " + charZ); // 정수가 문자로 변환되어 출력
  }
}
