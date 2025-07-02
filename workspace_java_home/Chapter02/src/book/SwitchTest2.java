public class SwitchTest2 {
  public static void main(String[] args) {
    // 의도적으로 수행문과 break를 없이 사용할 수도 있다.
    int month = 8;
    switch(month){
      case 1 :
      case 2 :
      case 3 :
        System.out.println(month + "월은 봄입니다.");
        break;
      case 4 :
      case 5 :
      case 6 :
        System.out.println(month + "월은 여름입니다.");
        break;
      case 7 :
      case 8 :
      case 9 :
        System.out.println(month + "월은 가을입니다.");
        break;
      case 10 :
      case 11 :
      case 12 :
        System.out.println(month + "월은 겨울입니다.");
        break;
      default :
        System.out.println(month + "은(는) 1~12사이의 정수가 아닙니다.");

    }
  }
}
