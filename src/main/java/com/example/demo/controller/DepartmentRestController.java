package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.handler.Utils;
import com.example.demo.model.Department;
import com.example.demo.model.Region;
import com.example.demo.model.dto.DepartmentDTO;
import com.example.demo.service.DepartmentService;
import com.example.demo.service.RegionService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;



@RestController
@RequestMapping("department/api")
public class DepartmentRestController {
  
  @Autowired
  private DepartmentService departmentService;

  @Autowired
  private RegionService regionService;

  @GetMapping("departments")
  public ResponseEntity<Object> get(@RequestHeader("x-token") String token) {
      if(token.equals("test") ){
            List<Department> departments = departmentService.get();
            return Utils.generateResponseEntity(HttpStatus.OK, "Data has been retrieved", departments);
        }
        return Utils.generateResponseEntity(HttpStatus.BAD_REQUEST, "Token is not valid");
  }

  @GetMapping("department/{id}")
    public Department getDepartment(@PathVariable Integer id) {
        Department department = departmentService.get(id);
        return department;
    }
  
  @PostMapping("save")
  public String save(@RequestBody DepartmentDTO departmentDto) {  
      Region region = regionService.get(departmentDto.getRegionId());
      Department department = new Department(departmentDto.getId(), departmentDto.getName(), region);
      return departmentService.save(department)? "Data added successfully" : "Failed to add data";
  }

  @DeleteMapping("delete/{id}")
    public String delete(@PathVariable Integer id) {
        return departmentService.delete(id) ? "Data sucessfully deleted" : "Data not found";
    }
    
}
