package com.green.mem.clothing_category.service;

import com.green.mem.clothing_category.dto.ClothingCategoryDTO;
import com.green.mem.clothing_category.mapper.ClothingCategoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothingCategoryService {
  private final ClothingCategoryMapper clothesCategoryMapper;

  // 옷 카테고리 목록 조회
  public List<ClothingCategoryDTO> getCateList(){
    return clothesCategoryMapper.getCateList();
  }
}
