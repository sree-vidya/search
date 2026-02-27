package com.example.demo.specification;

import com.example.demo.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> givenName(String name){

        return (root,query,criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("name"),name);
        };
    }
}
