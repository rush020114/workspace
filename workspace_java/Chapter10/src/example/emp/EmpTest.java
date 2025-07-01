package example.emp;

public class EmpTest {
  public static void main(String[] args) {
    EmpService empService = new EmpService();
    empService.login();
    empService.printSalaryInfo();
    empService.updateSalary();
  }
}
