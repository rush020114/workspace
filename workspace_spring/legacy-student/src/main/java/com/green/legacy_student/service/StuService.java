package com.green.legacy_student.service;

import com.green.legacy_student.mapper.StuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StuService {
  private final StuMapper stuMapper;
}
