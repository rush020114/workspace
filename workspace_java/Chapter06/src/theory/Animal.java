package theory;

// 강아지, 고양이, 소
// 케이지 5개
// 5개의 케이지는 강아지, 고양이, 소가 들어간다.
public class Animal {
  public void sound(){
    System.out.println("동물이 웁니다.");
  }
}

class Dog extends  Animal{
  public void sound(){
    System.out.println("강아지가 웁니다.");
  }
}

class Cat extends Animal{
  public void sound(){
    System.out.println("고양이가 웁니다.");
  }
}

class Cow extends  Animal{
  public void sound(){
    System.out.println("소가 웁니다.");
  }
}
