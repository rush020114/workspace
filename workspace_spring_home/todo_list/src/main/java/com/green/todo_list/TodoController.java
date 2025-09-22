package com.green.todo_list;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
  private final TodoService todoService;

  // 할 일 목록 조회
  @GetMapping("")
  public List<TodoDTO> getTodoList(){
    return todoService.getTodoList();
  }
}
