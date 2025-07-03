package theory;

public class Cake {
  public void eatCake(){
    System.out.println("케이크를 먹다.");
  }
}

class CheeseCake extends Cake{
  public void eatCheeseCake(){
    System.out.println("치즈 케이크를 먹다.");
  }
}

class StrawberryCheeseCake extends CheeseCake{
  public void eatStrawberryCheeseCake(){
    System.out.println("딸기치즈 케이크를 먹다.");
  }
}