public class RelationOp {
  public static void main(String[] args){
    System.out.println("3 >= 2 = " + (3 >= 2)); // 3은 2보다 크므로 true를 반환
    System.out.println("3 <= 2 = " + (3 <= 2)); // 3은 2보다 작으므로 false를 반환
    System.out.println("7.0 = 7" + (7.0 == 7)); // 7이 알아서 실수로 형변환되어 true값 반환
    System.out.println("7.0 != 7" + (7.0 != 7)); // 위의 결과로써 false 반환

  }
}
