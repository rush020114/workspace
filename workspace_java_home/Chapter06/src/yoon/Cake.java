package yoon;

public class Cake {
  public void sweet(){
    System.out.println("달콤");
  }

  public void yummy(){
    System.out.println("Yummy Cake");
  }
}

class CheeseCake extends Cake{
  public void milky(){
    System.out.println("고소");
  }

  public void yummy(){
    super.yummy();
    System.out.println("Yummy Cheese Cake");
  }
}

class StrawberryCheeseCake extends CheeseCake{
  public void sour(){
    System.out.println("새콤");
  }

  public void yummy(){
    super.yummy();
    System.out.println("Yummy Strawberry Cheese Cake");
  }
}

