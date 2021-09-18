package com.africom.jackton.studentdemo.service;

import com.africom.jackton.studentdemo.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee,long id);
    Void deleteEmployee(long id);
}
