package com.green.mem.clothing.service;

import com.green.mem.clothing.dto.ClothingDTO;
import com.green.mem.clothing.dto.ClothingImgDTO;
import com.green.mem.clothing.mapper.ClothingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothingService {
  private final ClothingMapper clothingMapper;

  // 옷 등록
  @Transactional(rollbackFor = Exception.class)
  public void insertClothing(ClothingDTO clothingDTO, List<ClothingImgDTO> clothingImgDTOList){
    // 등록할 옷 번호 조회
    int nextClothingNum = clothingMapper.getNextClothingNum();

    // 옷 테이블, 옷 이미지 테이블의 옷번호를 채우기 위한 세터 호출
    clothingDTO.setClothingNum(nextClothingNum);
    for(ClothingImgDTO clothingImgDTO : clothingImgDTOList){
      clothingImgDTO.setClothingNum(nextClothingNum);
    }

    // 옷 등록
    clothingMapper.insertClothing(clothingDTO);

    // 옷 이미지 등록
    clothingMapper.insertClothingImgs(clothingImgDTOList);
  }

  // 옷 목록 조회
  public List<ClothingDTO> getClothingList(){
    return clothingMapper.getClothingList();
  }

  // 옷 상세 조회
  public ClothingDTO getClothing(int clothingNum){
    return clothingMapper.getClothing(clothingNum);
  }
}
