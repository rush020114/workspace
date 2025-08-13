package com.green.backend_student.mapper;

import com.green.backend_student.dto.ClassDTO;
import com.green.backend_student.dto.StuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuMapper {
  // 모든 학급명 조회
  List<ClassDTO> getClassInfo();

  // 모든 반의 학생 조회
  List<StuDTO> getStudentInfo(ClassDTO classDTO);

}
