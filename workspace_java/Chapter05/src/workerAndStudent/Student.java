package workerAndStudent;

public class Student {
  private PersonInfo personInfo;
  private Sungjuk sungjuk;

  public Student(){
  }

  public void setInfo(String name, int age, String addr){
    personInfo = new PersonInfo(name, age, addr);
  }

  public void setSungjuk(int korScore, int engScore, int mathScore){
    sungjuk = new Sungjuk(korScore, engScore, mathScore);
  }

  public void displayStudentInfo(){
    personInfo.displayPersonInfo();
    sungjuk.displaySungjukInfo();
  }
}
