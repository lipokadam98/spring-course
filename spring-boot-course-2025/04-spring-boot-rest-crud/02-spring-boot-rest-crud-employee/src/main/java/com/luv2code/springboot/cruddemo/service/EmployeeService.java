package com.luv2code.springboot.cruddemo.service;

import com.luv2code.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(int id);

    List<Employee> findAll();

    Employee save(Employee employee);

    void deleteById(int id);
}
