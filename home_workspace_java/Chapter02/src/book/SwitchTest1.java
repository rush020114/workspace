public class SwitchTest1 {
  public static void main(String[] args) {
    // switch문 : switch의 기준값과 case의 비교값과 수행문으로 구성되어 있다.
    // switch문의 기준값과 동일한 비교값의 수행문이 실행된다.
    // 일치하는 비교값이 없을 때 실행하고 싶으면 default를 사용한다.
    char grade1 = 'C';
    switch(grade1){
      case 'A':
        System.out.println("A 등급은 90~100점 사이의 점수입니다.");
      case 'B':
        System.out.println("B 등급은 90~100점 사이의 점수입니다.");
      case 'C':
        System.out.println("C 등급은 90~100점 사이의 점수입니다.");
      case 'D':
        System.out.println("D 등급은 90~100점 사이의 점수입니다.");
      default :
        System.out.println("존재하지 않눈 등급입니다.");
    }

    // break를 사용하지 않으면 기준값과 비교값이 일치하는 곳부터 switch문 안의 모든 수행문을 실행한다.
    // break를 사용하면 특정 case만 실행하고 switch문을 종료할 수 있다.
    char grade2 = 'D';
    switch(grade2){
      case 'A':
        System.out.println("A 등급은 90~100점 사이의 점수입니다.");
        break;
      case 'B':
      System.out.println("B 등급은 90~100점 사이의 점수입니다.");
        break;
      case 'C':
      System.out.println("C 등급은 90~100점 사이의 점수입니다.");
        break;
      case 'D':
      System.out.println("D 등급은 90~100점 사이의 점수입니다.");
        break;
      default :
        System.out.println("존재하지 않눈 등급입니다.");
    }

  }
}
