public class SolutionTest {
  public static void main(String[] args) {
    String str = "java";
    System.out.println(str.substring(1,2));
    System.out.println(str.length());
    System.out.println("a" + "v" + "a" + "j");
    String str2 = "";
    for(int i = str.length() - 1 ; i > -1 ; i++){
      str2 = str.substring(i, i + 1);
    }

    System.out.println(str2);
  }
}
