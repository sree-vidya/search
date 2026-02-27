package com.example.demo.controller;

import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping(value = "/emp",params = {"page","size","sortBy","name"})
    public ResponseEntity<List<Employee>> getEmployees(@RequestParam("page") int page,
                                                       @RequestParam("size") int size,
                                                       @RequestParam("sortBy") Optional<String> sortBy,
                                                       @RequestParam("name") String name){

        List<Employee> employees = service.searchEmployees( page, size,sortBy,name).getContent();
        return  ResponseEntity.of(Optional.of(employees)) ;
    }
}
