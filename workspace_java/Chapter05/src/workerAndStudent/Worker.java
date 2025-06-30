package workerAndStudent;

public class Worker {
  private WorkerInfo workerInfo;
  private PersonInfo personInfo;

  public Worker(){
  }

  public void setInfo(String name, int age, String addr){
    personInfo = new PersonInfo(name, age, addr);
  }

  public void setWorkInfo(String company, String dept, int pay){
    workerInfo = new WorkerInfo(company, dept, pay);
  }

  public void displayWorker(){
    personInfo.displayPersonInfo();
    workerInfo.displayWorkerInfo();
  }
}
