package com.green.todo_list;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TodoDTO {
  private int todoNum;
  private String todoTitle;
}
