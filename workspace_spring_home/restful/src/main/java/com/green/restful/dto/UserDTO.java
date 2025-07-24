package com.green.restful.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
  private String id;
  private String pw;
  private String name;
  private String addr;

  public UserDTO(){
  }

  public UserDTO(String id, String pw, String name, String addr) {
    this.id = id;
    this.pw = pw;
    this.name = name;
    this.addr = addr;
  }

  public String toString(){
    return "id: " + id + ", pw: " + pw + ", 이름: " + name + ", 주소: " + addr;
  }
}
