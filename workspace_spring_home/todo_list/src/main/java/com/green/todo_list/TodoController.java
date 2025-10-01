package com.green.todo_list;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
  private final TodoService todoService;

  // 할 일 목록 조회
  @GetMapping("")
  public ResponseEntity<?> getTodoList(){
    try{
      return ResponseEntity
              .status(HttpStatus.OK)
              .body(todoService.getTodoList());
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("조회 중 서버 오류 발생");
    }
  }

  // 할 일 등록
  @PostMapping("")
  public ResponseEntity<?> regTodo(@RequestBody TodoDTO todoDTO){
    try {
      todoService.regTodo(todoDTO);
      return ResponseEntity
              .status(HttpStatus.CREATED)
              .body("등록 완료");
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("등록 중 서버 오류 발생");
    }
  }

}
