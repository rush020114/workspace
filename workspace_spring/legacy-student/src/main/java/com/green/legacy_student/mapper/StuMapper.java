package com.green.legacy_student.mapper;

import com.green.legacy_student.dto.ClassDTO;
import com.green.legacy_student.dto.StuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuMapper {
  // 학급 목록
  List<ClassDTO> getClassList();

  // 학생 목록
  List<ClassDTO> getStuList();

  List<StuDTO> getStuListAgain(int classNum);

  StuDTO getStuDetail(int stuNum);
}
