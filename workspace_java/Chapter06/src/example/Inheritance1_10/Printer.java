package example.Inheritance1_10;

public class Printer {
  protected String modelName;
  protected String Company;
  protected String anInterface;
  protected int printNum;
  protected int leftPage;

  public Printer(String modelName, String company, String anInterface, int printNum){
    this.modelName = modelName;
    this.Company = company;
    this.anInterface = anInterface;
    this.printNum = printNum;
    leftPage = 100;
  }

  public void setLeftPage(int leftPage){
    this.leftPage = leftPage;
  }

  public int getLeftPage(){
    return leftPage;
  }

  protected void print(){
    leftPage--;
  }
}
