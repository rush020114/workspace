package com.green.todo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
  List<TodoDTO> getTodoList();

  void regTodo(String todoTitle);
}
