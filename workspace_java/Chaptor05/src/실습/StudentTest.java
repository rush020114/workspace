package 실습;

public class StudentTest {
  public static void main(String[] args){
    Student s1 = new Student();
    String[] info = {"홍길동", "울산", "010 1234 5678"};
    int[] numInfo = {20, 25};
    s1.setStudentInfo(info, numInfo);
    s1.printStudentInfo();
    s1.setName("이순신");
    s1.printStudentInfo();
    s1.setAge(15);
    s1.printStudentInfo();
    s1.setAddress("부산");
    s1.printStudentInfo();
    s1.setStudentNum(24);
    s1.printStudentInfo();
    s1.setPhoneNum("010 2345 6789");
    s1.printStudentInfo();
    System.out.println(s1.returnName("유관순"));
    System.out.println(s1.returnAge(25));
    System.out.println(s1.returnAddress("서울"));
    System.out.println(s1.returnStudentNum(23));
    System.out.println(s1.returnPhoneNum("010 3456 7890"));
  }
}
