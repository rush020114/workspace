package com.green.restful.controller;

import com.green.restful.EmpDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmpController {

  // 모든 사원 정보를 조회하는 API
  @GetMapping("/emps")
  public String getEmpList(){
    return "모든 사원 조회";
  }

  // 한 명의 사원 정보를 조회하는 API
  @GetMapping("/emps/{empNo}")
  public String getEmp(@PathVariable("empNo") int a){
    return "사원 한 명 조회";
  }

  // 한 명의 사원을 등록하는 API (사원명, 직급, 급여 정보를 등록)
  @PostMapping("/emps")
  public String insertEmp(@RequestBody EmpDTO empDTO){
    System.out.println(empDTO);
    return "사원 한 명 등록";
  }

  // 한 명의 사원을 삭제하는 API
  @DeleteMapping("/emps/{empNo}")
  public String deleteEmp(@PathVariable("empNo") int a){
    return "사원 한 명 삭제";
  }

  // 한 명의 사원정보를 수정하는 API(직급, 급여 수정)
  @PutMapping("/emps/{empNo}")
  public String updateEmp(@RequestBody EmpDTO empDTO, @PathVariable("empNo") int a){
    System.out.println(empDTO);
    System.out.println(a);
    return "사원 한 명 수정";
  }
}
