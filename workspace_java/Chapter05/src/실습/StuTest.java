package 실습;

public class StuTest {
  public static void main(String[] args){
    StuManager stuManager = new StuManager();
    stuManager.regStudent();
    stuManager.regStudent();
    stuManager.regStudent();
    stuManager.regStudent();
    stuManager.regStudent();
    stuManager.printStudentInfoAll();
  }
}
