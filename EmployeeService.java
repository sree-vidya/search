package com.example.demo.service;

import com.example.demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.specification.EmployeeSpecification;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public Page<Employee> searchEmployees(int page, int size, Optional<String> sortBy,String name){

        Pageable pageable = PageRequest.of(
                page,
                size,
                Sort.by(sortBy.orElse("")).ascending()
        );
       return repo.findAll(EmployeeSpecification.givenName(name),pageable);
    }
}
