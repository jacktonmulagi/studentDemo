package com.africom.jackton.studentdemo.service.impl;

import com.africom.jackton.studentdemo.exception.ResourceNotFoundException;
import com.africom.jackton.studentdemo.model.Employee;
import com.africom.jackton.studentdemo.repository.EmployeeRepository;
import com.africom.jackton.studentdemo.service.EmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
//   Starting with Spring 4.3 ,if a class which is configured as a Spring bean has only one constructor,the @Autowired annotation can be omitted and Spring will use that constructor and
//    inject all necessary dependencies.
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
     return  employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
//        we need to check whether employee with the given id is existed in the DB or not
        Employee existingEmployeee = employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        existingEmployeee.setFirstName(employee.getFirstName());
        existingEmployeee.setLastName(employee.getLastName());
        existingEmployeee.setEmail(employee.getEmail());
//        save existing employee to DB
        employeeRepository.save(existingEmployeee);
        return existingEmployeee;
    }

    @Override
    public Void deleteEmployee(long id) {
        //        we need to check whether employee with the given id is existed in the DB or not
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Employee","Id",id));
        employeeRepository.deleteById(id);
        return null;
    }
}
