package academy.user;

public class User {
  private String username;
  private String password;

  public User(String username, String password){
    this.username = username;
    this.password = password;
  }

  public boolean login(String inputId, String inputPw){
    return username.equals(inputId) && password.equals(inputPw);
  }
}
