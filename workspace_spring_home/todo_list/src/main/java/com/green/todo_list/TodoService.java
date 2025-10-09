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

  // 할 일 삭제
  public void deleteTodo(int todoNum){
    todoMapper.deleteTodo(todoNum);
  }

  // 할 일 수정
  public void updateTodo(TodoDTO todoDTO){
    todoMapper.updateTodo(todoDTO);
  }
}
