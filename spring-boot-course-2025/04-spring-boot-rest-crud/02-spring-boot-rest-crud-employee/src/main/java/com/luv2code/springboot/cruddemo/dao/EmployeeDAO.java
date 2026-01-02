package com.luv2code.springboot.cruddemo.dao;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    Employee save(Employee theEmployee);

    Employee findById(int theId);

    void deleteById(int theId);

    List<Employee> findAll();
}
