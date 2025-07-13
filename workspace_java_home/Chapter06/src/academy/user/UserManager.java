package academy.user;

public class UserManager {
  public static void main(String[] args){
    User[] users = new User[] {new User("kim", "1111"),new User("lee", "2222"),new User("park", "3333"),new User("choi", "4444"),new User("jung", "5555")};

    System.out.println(users[0].login("kim", "1111"));
  }
}
