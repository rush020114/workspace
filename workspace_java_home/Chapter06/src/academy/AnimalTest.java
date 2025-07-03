package academy;

public class AnimalTest {
  public static void main(String[] args){
    Animal[] animals = new Animal[5];

    for(int i = 0 ; i < animals.length ; i++){ // 개와 고양이를 번갈아 가며 animal 배열에 넣겠다.
      if (i % 2 == 0) {
        animals[i] = new Dog(); // 상속의 다형성으로 인해 부모 클래스가 자식 클래스를 받을 수 있다.
      }

      else{
        animals[i] = new Cat();
      }
    }

    for(Animal animal : animals){
      animal.sound(); // 오버라이딩된 개와 고양이 메서드가 번갈아가며 실행
    }

  }
}
