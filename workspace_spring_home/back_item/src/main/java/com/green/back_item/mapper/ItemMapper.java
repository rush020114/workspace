package com.green.back_item.mapper;

import com.green.back_item.dto.ItemDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
  // 상품 목록 조회
  List<ItemDTO> getItemList();

  // 하나의 상품 조회
  ItemDTO getItem(int itemNum);

  // 상품 등록
  int insertItem(ItemDTO itemDTO);

  // 하나의 상품 삭제
  int deleteItem(int itemNum);

  // 하나의 상품 수정
  int updateItem(ItemDTO itemDTO);
}
