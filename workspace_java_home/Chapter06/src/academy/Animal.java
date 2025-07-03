package academy;

public class Animal {
  public void sound(){ // 부모 클래스 자료형이 자식 클래스를 받으면 이 클래스밖에 실행 못하지만 메서드 오버라이딩이 되며 자식 메서드를 실행하게 된다.
    System.out.println("동물 소리");
  }
}

class Dog extends Animal{
  public void sound(){
    System.out.println("개 소리");
  }
}

class Cat extends Animal{
  public void sound(){
    System.out.println("고양이 소리");
  }
}