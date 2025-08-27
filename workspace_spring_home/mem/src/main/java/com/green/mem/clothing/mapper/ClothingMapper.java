package com.green.mem.clothing.mapper;

import com.green.mem.clothing.dto.ClothingDTO;
import com.green.mem.clothing.dto.ClothingImgDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClothingMapper {
  // 옷 등록
  void insertClothing(ClothingDTO clothingDTO);

  // 등록할 옷 번호 조회
  int getNextClothingNum();

  // 옷 이미지 등록
  void insertClothingImgs(List<ClothingImgDTO> clothingImgDTOList);

  // 옷 목록 조회
  List<ClothingDTO> getClothingList();

  // 옷 상세 조회
  ClothingDTO getClothing(int clothingNum);
}
