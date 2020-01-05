package com.packt.webstore.service;

import com.packt.webstore.domain.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee save(Employee employee);

    public Employee findOne(long id);
}
