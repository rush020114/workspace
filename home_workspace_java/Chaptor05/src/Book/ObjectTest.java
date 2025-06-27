package Book;

public class ObjectTest {
  public static void main(String[] args){
    Student kim = new Student();
    kim.score = 83;
    System.out.println("kim 점수 : " + kim.score);

    // 객체의 주소 복사
    // 기본 타입의 변수와 달리 참조 변수는 객체의 주소 정보를 참조하므로
    // kim 객체를 새로운 참조 변수에 저장하면 두 참조변수는 같은 주소 정보를 갖고 동일한 객체를 참조하게 된다.
    // 따라서 kim 참조변수를 통해 Student객체의 멤버변수를 변경시키면 copyKim도 변경된 값이 출력되는 것이다.
    // 그래서 이것을 객체의 공유라고 한다.
    Student copyKim = kim;

    copyKim.score = 65;
    System.out.println("copyKim 점수 : " + copyKim.score);
    System.out.println("kim의 점수 : " + kim.score);
  }
}
