package 이론;

public class Phone {
  String modelName;
  int price;
  String os;

  // 폰의 모델명을 모델명을 변경하는 메서드
  public void setModelName(String newName){
    modelName = newName;
  }

  // 폰의 가격을 변경하는 기능
  public void setPrice(int newPrice){
    price = newPrice;
  }

  // 폰의 os를 변경하는 기능
  public void setOs(String newOs){
    os = newOs;
  }

  // 폰의 모델명, 가격, os모두를 변경하는 기능
  public void setPhoneInfo(String newName, int newPrice, String newOs){
    modelName = newName;
    price = newPrice;
    os = newOs;
  }

  // 폰의 모델명, 가격, os 정보를 출력하는 기능
  public void checkPhoneInfo(){
    System.out.println("모델명 : " + modelName);
    System.out.println("가격 : " + price);
    System.out.println("OS : " + os);
  }
}
