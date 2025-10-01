package com.green.todo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {
  public final TodoService todoService;

  @GetMapping("")
  public ResponseEntity<?> getTodoList(){
    List<TodoDTO> todoDTOList = todoService.getTodoList();
    try {
      return ResponseEntity
              .status(HttpStatus.OK)
              .body(todoDTOList);
    }catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity
              .status(HttpStatus.INTERNAL_SERVER_ERROR)
              .body("할 일 목록 조회 중 오류가 발생했습니다.");
    }
  }

  @PostMapping("")
  public ResponseEntity<?> regTodo(@RequestBody TodoDTO todoDTO){
    try {
      // 제목으로 빈 문자가 전달됐으면
      if(todoDTO.getTodoTitle().isEmpty()){
        // 강제로 예외(오류)를 발생
        throw new Exception();
      }
      todoService.regTodo(todoDTO.getTodoTitle());
      return ResponseEntity
              .status(HttpStatus.CREATED)
              .build();
    }catch (Exception e) {

      // 앱에서 입력한 할 일 제목이 이상한 경우와 쿼리문 자체에 오류가 있을 경우를 판단하는 변수
      // param : 매개변수
      boolean isParamError = todoDTO.getTodoTitle() == null || todoDTO.getTodoTitle().isEmpty();

      e.printStackTrace();
      return ResponseEntity
              .status(
                isParamError ?
                HttpStatus.BAD_REQUEST :
                HttpStatus.INTERNAL_SERVER_ERROR
              )
              .body(
                isParamError ?
                "입력한 제목 데이터가 올바르지 않습니다." :
                "할 일 등록 기능 실행 주 오류 발생했습니다."
              );
    }
  }

  @DeleteMapping("/{todoNum}")
  public ResponseEntity<?> deleteTodo(@PathVariable("todoNum") int todoNum){
    try {
      if(todoNum <= 0){
        throw new Exception();
      }
      todoService.deleteTodo(todoNum);
      return ResponseEntity
              .status(HttpStatus.OK)
              .body("삭제 성공");
    } catch (Exception e) {
      e.printStackTrace();

      boolean isParamError = todoNum <= 0;

      return  ResponseEntity
              .status(
                isParamError ? HttpStatus.BAD_REQUEST : HttpStatus.INTERNAL_SERVER_ERROR
              )
              .body(
                isParamError ?
                "전달된 할 일 번호가 정상적이지 않습니다." :
                "할 일 삭제 기능 실행 중 오류가 발생했습니다."
              );

    }
  }
}
