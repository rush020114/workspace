package com.green.legacy_student.service;

import com.green.legacy_student.dto.ClassDTO;
import com.green.legacy_student.dto.StuDTO;
import com.green.legacy_student.mapper.StuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StuService {
  private final StuMapper stuMapper;

  public List<ClassDTO> getClassList(){
    return stuMapper.getClassList();
  }

  public List<ClassDTO> getStuList(){
    return stuMapper.getStuList();
  }

  public List<StuDTO> getStuListAgain(int classNum){
    return stuMapper.getStuListAgain(classNum);
  }

  public StuDTO getStuDetail(int stuNum){
    return stuMapper.getStuDetail(stuNum);
  }
}
