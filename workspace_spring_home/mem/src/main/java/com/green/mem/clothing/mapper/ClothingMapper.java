package com.green.mem.clothing.mapper;

import com.green.mem.clothing.dto.ClothingDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClothingMapper {
  // 옷 등록
  int insertClothing(ClothingDTO clothingDTO);

  // 옷 목록 조회
  List<ClothingDTO> getClothingList();

  // 옷 상세 조회
  ClothingDTO getClothing(int clothingNum);
}
