package com.green.todo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TodoController {
  public final TodoService todoService;

  @GetMapping("")
  public List<TodoDTO> getTodoList(){
    return todoService.getTodoList();
  }
}
