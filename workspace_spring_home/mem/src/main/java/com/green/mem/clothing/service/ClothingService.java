package com.green.mem.clothing.service;

import com.green.mem.clothing.dto.ClothingDTO;
import com.green.mem.clothing.mapper.ClothingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClothingService {
  private final ClothingMapper clothingMapper;

  // 옷 등록
  public int insertClothing(ClothingDTO clothingDTO){
    return clothingMapper.insertClothing(clothingDTO);
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
