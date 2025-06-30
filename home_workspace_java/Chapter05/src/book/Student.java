package book;

// 자바는 객체지향 프로그램이다.
// 객체란 현실세계에 있는 유/무형의 모든 것을 의미한다.
// 우리가 프로그램에서 객체를 이용하기 위해서는 객체를 추상화해서 인스턴스로 이용한다.
// 객체를 추상화하는 과정이 클래스를 만드는 것이고 그 클래스를 실제로 이용할 수 있는 것이 인스턴스이다.

// 클래스 선언부
// 클래스는 하나의 파일에 여러 개 만들 수 있지만 하나만 만든다. public 한 개가 형성되면 나머지는 default로밖에 형성되지 못한다.
public class Student {

  // 멤버 변수
  // 멤버 변수는 메인 메서드가 아닌 다른 메서드에서도 사용할 수 있고 다른 클래스에서도 사용 가능하다.
  public String name;
  int score;
  public int firstScore;
  public int secondScore;

  // 접근제한자 : 외부에 공개할 정보와 그렇지 않은 정보를 구분하여 외부로부터의 접근을 제한하기 위해 사용.
  // private score; <- score 변수에 대한 모든 접근을 차단
  // public name; <- name 변수에 대한 모든 접근을 허용

  // 생성자 메서드
  // 생성자는 멤버변수의 초기화 기능을 담당한다. 생성자호출은 클래스로부터 객체를 생성할 때다.
  // 즉 생성자를 통해 클래스로부터 객체를 생성할 수 있으며, 초기화까지 진행할 수 있다.
  Student(){
    System.out.println("---> Student 객체 생성");
    name = "둘리";
    score = 93;
  }

  // 지역 변수만 사용하는 메서드
  // 더해주는 기능만 필요하여 매개변수가 필요없다.
  public void forTest(){
    int sum = 0;
    for(int i = 1 ; i < 101 ; i++){
      sum += i;
    }
    System.out.println("1 ~ 100까지의 합 : " + sum);
  }

  // 메서드
  // 메서드는 기능이다.
  // 멤버변수만 사용하는 메서드
  void printInfo(){
    System.out.println(name +  "의 점수 : " + score);
  }

  // 멤버 변수와 지역변수(매개 변수)를 모두 사용하는 메서드
  public void printAvg(int javaScore, int pythonScore, int sqlScore){
    System.out.println("printAvg(int, int, int) 호출");
    int sumScore = javaScore + pythonScore + sqlScore;
    int avgScore = sumScore / 3;
    System.out.println(name + "의 세 과목의 평균 점수 : " + avgScore);
  }


  // return 키워드를 이용하면 호출한 쪽으로 수행결과를 반환한다. 반환한 자료형과 리턴타입이 동일해야 함.
  public int forReturn(){
    int sum = 0;
    for(int i = 1 ; i < 101 ; i++){
      sum += i;
    }
    return sum;
  }

  int printReturnInfo(){
    System.out.println(name +  "의 점수 : " + score);
    return score;
  }

  int printAvg(int javaScore, int pythonScore){
    int sumScore = javaScore + pythonScore;
    int avgScore = sumScore / 2;
    return avgScore;
  }
  int printAvg(int javaScore, double pythonScore, int sqlScore){
    int sumScore = javaScore + (int)pythonScore + sqlScore;
    int avgScore = sumScore / 3;
    return avgScore;
  }
  int printAvg(double javaScore, int pythonScore){
    int sumScore = (int)javaScore + pythonScore; // 또 다른 두 과목의 평균을 강제 형병환을 통해 가능하게 만듦(대신 매개변수로 소수를 입력해야 함)
    int avgScore = sumScore / 2;
    return avgScore;
  }
}
