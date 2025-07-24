package com.green.restful.controller;

import com.green.restful.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
  @PostMapping("/users")
  public String insertUser(@RequestBody UserDTO userDTO){
    System.out.println(userDTO);
    return "하나의 사용자 등록 완료";
  }
}
