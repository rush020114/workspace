package com.green.mem.clothing.controller;

import com.green.mem.clothing.dto.ClothingDTO;
import com.green.mem.clothing.dto.ClothingImgDTO;
import com.green.mem.clothing.service.ClothingService;
import com.green.mem.util.FileUploadUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/clothes")
public class ClothingController {
  private final ClothingService clothingService;

  // 옷 등록 api
  @PostMapping("")
  public void insertClothing(@RequestParam("mainImg")MultipartFile mainImg
                            , @RequestParam(name = "subImgs", required = false) MultipartFile[] subImgs
                            , ClothingDTO clothingDTO){

    // 이미지 업로드 후 옷 이미지 쿼리 빈값 채우는 메서드 실행
    ClothingImgDTO clothingImgDTO = FileUploadUtil.fileUpload(mainImg);
    List<ClothingImgDTO> clothingImgDTOList = FileUploadUtil.multipleFileUpload(subImgs);
    clothingImgDTOList.add(clothingImgDTO);

    // 옷 등록 기능 실행
    clothingService.insertClothing(clothingDTO, clothingImgDTOList);
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
