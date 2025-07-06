package academy.school;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School {
  private List<StudyClass> studyClasses;
  Scanner sc;
  int cnt;
  int[] studentCount;

  public School(){
    studentCount = new int[3];
    cnt = 0;
    sc = new Scanner(System.in);
    studyClasses = new ArrayList<>();
    System.out.println("교실등록을 시작합니다.");
    while(true){
      if(cnt <= 2){
      System.out.print("반이름 : ");
      String className = sc.next();
      System.out.print("교사이름 : ");
      String teacher = sc.next();
      studyClasses.add(new StudyClass(className, teacher));
      cnt++;
      }
      else{
        System.out.println("교실등록을 마칩니다.");
        break;
      }
    }
  }

  public void regStudent(){
    System.out.println("학생등록을 시작합니다.");
    System.out.print("반이름을 선택해주세요(A반, B반, C반) : ");
    String selectClassName = sc.next();
    switch(selectClassName){
      case "A":
        System.out.println(selectClassName + "반 학생 등록을 시작합니다.");
        System.out.print("이름 : ");
        String name1 = sc.next();
        System.out.print("나이 : ");
        int age1 = sc.nextInt();
        System.out.print("성적 : ");
        int score1 = sc.nextInt();
        studyClasses.get(0).setStudent(name1, age1, score1);
        studentCount[0]++;
        System.out.println("학생 등록을 마칩니다. 현재 " + selectClassName + "반 학생 수는 " +  studentCount[0] + "명입니다.");
        break;
      case "B":
        System.out.println(selectClassName + "반 학생 등록을 시작합니다.");
        System.out.print("이름 : ");
        String name2 = sc.next();
        System.out.print("나이 : ");
        int age2 = sc.nextInt();
        System.out.print("성적 : ");
        int score2 = sc.nextInt();
        studyClasses.get(1).setStudent(name2, age2, score2);
        studentCount[1]++;
        System.out.println("학생 등록을 마칩니다. 현재 " + selectClassName + "반 학생 수는 " +  studentCount[1] + "명입니다.");
        break;
      case "C":
        System.out.println(selectClassName + "반 학생 등록을 시작합니다.");
        System.out.print("이름 : ");
        String name3 = sc.next();
        System.out.print("나이 : ");
        int age3 = sc.nextInt();
        System.out.print("성적 : ");
        int score3 = sc.nextInt();
        studyClasses.get(2).setStudent(name3, age3, score3);
        studentCount[2]++;
        System.out.println("학생 등록을 마칩니다. 현재 "+ selectClassName +"반 학생 수는 " +  studentCount[2] + "명입니다.");
        break;
      default:
        System.out.println("존재하지 않는 반입니다.");
    }
  }

  // 매개변수로 담당교사명을 받아, 해당 교사가 맡고 모든 반의 학생 정보 출력
  public void teacherOfClassInfo(String teacher){
    for(StudyClass studyClass : studyClasses){
      if(studyClass.getTeacher().equals(teacher)){
        studyClass.printAllStudentsInfo();
      }
    }
  }

  // 각 반별로 반별 평균 점수 및 전체 학급에 대한 평균 점수를 출력
  public void printEachClassAvgAndAllClassAvg(){
    double sum = 0;
    String[] strings = {"A", "B", "C"};
    for(int i = 0 ; i < studyClasses.size() ; i++){
      System.out.println(strings[i] + "반 평균 : " + studyClasses.get(i).returnClassAvg());
      sum += studyClasses.get(i).returnClassAvg();
    }
    System.out.println("전체 학급 평균 : " + (sum / studyClasses.size()));
  }

  // 모든 반에서 최고 성적을 가진 학생의 이름과 점수를 출력
  public void printAllClassHighScore(){
    int index = 0;
    int max = studyClasses.get(0).returnClassHighestScore().getScore();

    for(int i = 0 ; i < studyClasses.size() ; i++){
      if(max < studyClasses.get(i).returnClassHighestScore().getScore()){
        index++;
      }
    }
    System.out.println("이름 : " + studyClasses.get(index).returnClassHighestScore().getName());
    System.out.println("점수 : " + studyClasses.get(index).returnClassHighestScore().getScore());
  }

  // 매개변수로 반 이름을 받아, 해당 반의 평균을 출력하는 기능
  public void printClassAvg(String className){
    for(StudyClass studyClass : studyClasses){
      if(studyClass.getClassName().equals(className)){
        System.out.println(studyClass.returnClassAvg());
        return;
      }
    }
  }
}
