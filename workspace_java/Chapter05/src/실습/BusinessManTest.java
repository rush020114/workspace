package 실습;

public class BusinessManTest {
  public static void main(String[] args){
    BusinessMan man1 = new BusinessMan(1, "김", "개발부"); // BusinesssMan생성자로 값을 초기화한 BusinessMan클래스를 참조하는 변수
    BusinessMan man2 = new BusinessMan(2, "이", "연구부");
    BusinessMan man3 = new BusinessMan(4, "박", "개발부");
    BusinessMan man4 = new BusinessMan(5, "최", "연구부");
    BusinessMan man5 = new BusinessMan(8, "정", "개발부");

    BusinessMan[] businessMan = {man1, man2, man3, man4, man5}; // BusinesssMan에 대한 참조자료형을 배열로 가질 수 있는 배열 BusinessMan을 선언 및 생성
    for(int i = 0 ; i < businessMan.length ; i++){
      if(businessMan[i].getDepName().equals("개발부")){ // businessMan[i]의 요소의 getDepName기능(문자열 출력)이 "개발부"와 같다면
        businessMan[i].printBusinessMan(); // business[i]는 man(i+1)이다. man(i+1)의 printBusnissMan기능을 실행시켜라.
      }
    }

    for(int i = 0 ; i < businessMan.length ; i++){
      if(businessMan[i].getEnNum() >= 3){
        System.out.print(businessMan[i].getName() + " ");
      }
    }
    System.out.println();

    for(int i = 0 ; i < businessMan.length ; i++){
      if((businessMan[i].getDepName().equals("개발부")) && (businessMan[i].getEnNum() % 2 == 0)){
        businessMan[i].printBusinessMan();
      }
    }
  }
}
