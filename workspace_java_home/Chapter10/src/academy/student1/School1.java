package academy.student1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class School1 {
  Scanner sc;
  private List<StudyClass1> studyClass1List;

  public School1(){
    sc = new Scanner(System.in);
    studyClass1List = new ArrayList<>();
    for(int i = 0 ; i < 3 ; i++){
      regiClassStudy();
    }
  }

  // 교실 등록
  public void regiClassStudy(){
    System.out.println("교실을 추가합니다.");
    studyClass1List.add(insertStudyClassInfo());
  }

  // 매개변수로 담당교사 명을 받아, 해당 담당교사가 맡고 있는 모든 반의 학생 정보를 출력
  public void printStudentInfoTeacherOfStudyClass(String teacher){
    for(StudyClass1 studyClass : studyClass1List){
      if(studyClass.getTeacher().equals(teacher)){
        studyClass.printStudentInfoOfStudyClass();
      }
    }
  }

  // 각 반별로 반별 평균 점수 및 전체 학급에 대한 평균 점수 출력
  public void printEachStudyClassAvgAndAllStudyClassAvg(){
    double sum = 0;
    for(StudyClass1 studyClass : studyClass1List){
      System.out.println(studyClass.getAvgStudyClass());
      sum += studyClass.getAvgStudyClass();
    }
    System.out.print("학급 평균 : ");
    System.out.println(sum / studyClass1List.size());
  }

  // 모든 반에서 최고 성적을 가진 학생의 이름과 점수 출력
  public void printHighestScoreOfSchool(){
    int max = studyClass1List.get(0).getHighestScoreOfStudyClass().getScore();
    int index = 0;
    for(int i = 0 ; i < studyClass1List.size() ; i++){
      if(max < studyClass1List.get(i).getHighestScoreOfStudyClass().getScore()){
        max = studyClass1List.get(i).getHighestScoreOfStudyClass().getScore();
        index = i;
      }
    }
    System.out.println("전교 1등 학생");
    System.out.println(studyClass1List.get(index).getHighestScoreOfStudyClass());
  }

  // 매개변수로 반 이름을 받아 해당 반의 평균을 출력
  public void getStudyClassAvgInsertClassName(String className){
    for(int i = 0 ; i < studyClass1List.size() ; i++){
      if(studyClass1List.get(i).getClassName().equals(className)){
        System.out.println(className + "반 평균 : " + studyClass1List.get(i).getAvgStudyClass());
      }
    }
  }


  // 교실명, 교사 이름 입력
  public StudyClass1 insertStudyClassInfo(){
    System.out.print("교실 이름 : ");
    String className = sc.next();
    System.out.print("교사 이름 : ");
    String teacher = sc.next();
    return new StudyClass1(className, teacher);
  }
}
