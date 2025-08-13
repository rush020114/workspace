package com.green.backend_student.mapper;

import com.green.backend_student.dto.ClassDTO;
import com.green.backend_student.dto.StuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StuMapper {
  // 학급 목록 조회
  List<ClassDTO> getClassList();

  // 학생 목록(조인 사용) 조회
  List<StuDTO> getStuList(ClassDTO classDTO);
}
