package com.green.todo_list;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
  public final TodoMapper todoMapper;

  // 할 일 목록 조회
  public List<TodoDTO> getTodoList(){
    return todoMapper.getTodoList();
  }

  // 할 일 등록
  public void regTodo(TodoDTO todoDTO){
    todoMapper.regTodo(todoDTO);
  }
}
