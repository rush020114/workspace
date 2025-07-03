package theory;

public class AnimalHos {
  public static void main(String[] args){
    Animal[] animals = new Animal[5];
    animals[0] = new Animal();
    animals[1] = new Cow(); // 다형성으로 animal 배열에 cow(animal이 부모 클래스이므로)를 넣을 수 있다.(동물 달라하면 소를 줄 수 있다.)
    animals[2] = new Cat();
    animals[3] = new Cow();
    animals[4] = new Dog();

    for(Animal animal : animals){
      animal.sound(); // 만약 다형성이 적용된 객체를 실행하게 되면 부모 클래스의 기능밖에 쓰지 못하지만 실행하려 할 때 오버라이딩되어 있으면 실행이 자식 클래스로 된다.
    }
  }
}
