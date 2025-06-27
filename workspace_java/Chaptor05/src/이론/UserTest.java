package 이론;

public class UserTest {
  public static void main(String[] args){

    // User를 5명 저장할 수 있는 배열 users를 생성하세요.
    User[] users = new User[5]; // User자료형을 저장할 수 있는 공간을 생성
    User user1 = new User(1, "kim", 20);
    User user2 = new User(2, "lee", 30);
    User user3 = new User(3, "hong", 40);
    User user4 = new User(4, "choi", 50);
    User user5 = new User(5, "park", 60);
    users[0] = user1;
    users[1] = user2;
    users[2] = user3;
    users[3] = user4;
    users[4] = user5;

    users[0].display();

    for(int i = 0 ; i < users.length ; i++){
      users[i].display();
    }

    for(User e : users){
      e.display();
    }

    for(int i = 0 ; i < users.length ; i++){
      System.out.println(users[i].getName());
    }

    for(User e : users){ // users 배열의 요소를 처음부터 끝까지 하나하나씩 돌리겠다.(users각요소의 자료형은 User이므로 e는 User가 되어야 한다.
      System.out.println(e.getName());
    }

    for(int i = 0 ; i < users.length ; i++){
      if(users[i].getAge() > 30){
        users[i].display();
      }
    }

    for(User e : users){
      if(e.getAge() > 30){
        e.display();
      }
    }

  }
}
