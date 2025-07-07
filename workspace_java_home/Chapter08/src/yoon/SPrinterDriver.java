package yoon;

public class SPrinterDriver implements Printable{

  @Override
  public void print(String doc){
    System.out.print(doc);
    System.out.println(" From Samsung rinter");
  }

  public void print1(){
    System.out.println("oh");
  }
}
