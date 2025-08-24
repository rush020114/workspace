package com.green.mem.clothing_category.mapper;

import com.green.mem.clothing_category.dto.ClothingCategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClothingCategoryMapper {
  // 옷 카테고리 목록 조회
  List<ClothingCategoryDTO> getCateList();
}
