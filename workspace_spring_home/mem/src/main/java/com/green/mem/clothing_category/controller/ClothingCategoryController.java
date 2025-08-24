package com.green.mem.clothing_category.controller;

import com.green.mem.clothing_category.dto.ClothingCategoryDTO;
import com.green.mem.clothing_category.service.ClothingCategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/clothing-categories")
public class ClothingCategoryController {
  private final ClothingCategoryService clothesCategoryService;

  // 옷 카테고리 목록 조회 api
  @GetMapping("")
  public List<ClothingCategoryDTO> getCateList(){
    return clothesCategoryService.getCateList();
  }

}
