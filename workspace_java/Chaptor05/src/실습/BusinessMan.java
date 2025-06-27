package 실습;

public class BusinessMan {
  private int emNum;
  private String name;
  private String depName;

  public BusinessMan(int emNum, String name, String depName){
    this.emNum = emNum;
    this.name = name;
    this.depName = depName;
  }

  public void setEmNum(int emNum){
    this.emNum = emNum;
  }

  public void setName(String name){
    this.name = name;
  }

  public void setDepName(String depName){
    this.depName = depName;
  }

  public int getEnNum(){
    return emNum;
  }

  public String getName(){
    return name;
  }

  public String getDepName(){
    return depName;
  }

  public void printBusinessMan(){
    System.out.print("사번 : " + emNum + " | ");
    System.out.print("사원명 : " + name + " | ");
    System.out.println("부서명 : " + depName + " | ");
  }
}
