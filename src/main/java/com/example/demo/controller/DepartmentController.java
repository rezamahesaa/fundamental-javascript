package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("department")
public class DepartmentController {

    @GetMapping()
    public String index() {
        return "department/index";
    }
    
}
