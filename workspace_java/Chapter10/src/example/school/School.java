package example.school;

import java.util.ArrayList;
import java.util.List;

public class School {
  private List<StudyClass> studyClassList;

  public School(List<StudyClass> studyClassList){
    this.studyClassList = studyClassList;
  }

  // 매개변수로 담당교사명을 받아, 해당 담당교사가 맡고 있는 모든 반의 학생 정보를 출력
  public void teacherOfStudent(String teacher){
    for(StudyClass studyClass : studyClassList){
      if(studyClass.getTeacher().equals(teacher)){
        studyClass.printStudentInfoAll();
      }
    }
  }

  // 각 반별로 반별 평균 점수 및 전체 학급에 대한 평균 점수를 출력
  public void printEachClassScoreAvgAndAllStudentScoreAvg(){
    int sum = 0;
    int index = 1;
    for(StudyClass studyclass : studyClassList){
      System.out.println(index + " 반 평균 : " + studyclass.getStudentAvg());
      sum += studyclass.getStudentAvg();
      index++;
    }
    double avg = (double)sum / studyClassList.size();
    System.out.println("모든 반 평균 : " + avg);
  }

  // 모든 반에서 최고 성적을 가진 학생의 이름과 점수를 출력
  public void firstScoreInSchool(){
    int index = 0;
    int max = studyClassList.get(0).getStudentHighestScore().getScore();
    for(StudyClass studyClass : studyClassList){
      if(studyClass.getStudentHighestScore().getScore() > max){
        index++;
      }
    }
    System.out.println("이름 : " + studyClassList.get(index).getStudentHighestScore().getName());
    System.out.println("점수 : " + studyClassList.get(index).getStudentHighestScore().getScore());
  }

  // 매개변수로 반 이름을 받아, 해당 반의 평균을 리턴하는 기능
  public double getClassAvg(StudyClass studyClass){
    System.out.print(studyClass.getClassName() + "반의 평균 : ");
    return studyClass.getStudentAvg();
  }
}
