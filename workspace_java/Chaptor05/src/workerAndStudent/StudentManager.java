package workerAndStudent;

public class StudentManager {
  public static void main(String[] args){
    Student st = new Student();
    st.setInfo("김자바", 20, "울산");
    st.setSungjuk(80, 70, 90);
    st.displayStudentInfo();
  }
}
