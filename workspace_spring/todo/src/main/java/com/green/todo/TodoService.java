package com.green.todo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
  private final TodoMapper todoMapper;

  public List<TodoDTO> getTodoList(){
    return todoMapper.getTodoList();
  }

  public void regTodo(String todoTitle){
    todoMapper.regTodo(todoTitle);
  }

  public void deleteTodo(int todoNum){
    todoMapper.deleteTodo(todoNum);
  }
}
