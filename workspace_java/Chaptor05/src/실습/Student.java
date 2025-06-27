package 실습;

import java.util.Arrays;

public class Student {
  String[] info;
  int[] numInfo;

  public void setStudentInfo(String[] newInfo, int[] newNumInfo){
    info = newInfo;
    numInfo = newNumInfo;
  }

  public void setName(String newName){
    info[0] = newName;
  }

  public void setAge(int newAge){
    numInfo[0] = newAge;
  }

  public void setAddress(String newAddress){
    info[1] = newAddress;
  }

  public void setStudentNum(int newStudentNum){
    numInfo[1] = newStudentNum;
  }

  public void setPhoneNum(String newPhoneNum){
    info[2] = newPhoneNum;
  }

  public String returnName(String newName){
    info[0] = newName;
    return info[0];
  }

  public int returnAge(int newAge){
    numInfo[0] = newAge;
    return numInfo[0];
  }

  public String returnAddress(String newAddress){
    info[1] = newAddress;
    return info[1];
  }

  public int returnStudentNum(int newStudentNum){
    numInfo[1] = newStudentNum;
    return numInfo[1];
  }

  public String returnPhoneNum(String newPhoneNum){
    info[2] = newPhoneNum;
    return info[2];
  }

  public void printStudentInfo(){
    for(int i = 0 ; i < info.length ; i++){
      System.out.println(info[i]);
    }
    System.out.println(Arrays.toString(numInfo));
  }
}
