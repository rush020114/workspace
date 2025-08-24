package com.green.mem.clothing.controller;

import com.green.mem.clothing.dto.ClothingDTO;
import com.green.mem.clothing.service.ClothingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/clothes")
public class ClothingController {
  private final ClothingService clothingService;

  // 옷 등록 api
  @PostMapping("")
  public int insertClothing(@RequestBody ClothingDTO clothingDTO){
    return clothingService.insertClothing(clothingDTO);
  }

  // 옷 목록 조회
  @GetMapping("")
  public List<ClothingDTO> getClothingList(){
    return clothingService.getClothingList();
  }

  // 옷 상세 조회 api
  @GetMapping("/{clothingNum}")
  public ClothingDTO getClothing(@PathVariable("clothingNum") int clothingNum){
    return clothingService.getClothing(clothingNum);
  }
}
