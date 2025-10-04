package com.green.todo_list;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
  // 할일 목록 조회
  List<TodoDTO> getTodoList();

  // 할 일 등록
  void regTodo(TodoDTO todoDTO);

  // 할 일 삭제
  void deleteTodo(int todoNum);
}
