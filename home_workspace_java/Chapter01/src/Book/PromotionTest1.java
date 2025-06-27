public class PromotionTest1 {
  public static void main(String[] args){
    // 자동 형변환(Promotion) : 작은 크기의 데이터가 큰 데이터로 자동 변환
    int intAvg = 87;
    double doubleAvg = intAvg; // 작은 데이터int가 큰 데이터 double에 저장되면서 자동으로 형변환
    System.out.println(doubleAvg); // 정수가 실수가 됐으므로 87.0반환

  }
}
