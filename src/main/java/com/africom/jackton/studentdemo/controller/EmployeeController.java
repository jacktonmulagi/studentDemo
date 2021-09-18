package com.africom.jackton.studentdemo.controller;

import com.africom.jackton.studentdemo.model.Employee;
import com.africom.jackton.studentdemo.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// @RestController is a convenient annotation that combines @Controller and @ResponseBody , which eliminates the need to annotate every request handling method of the controller class with
// the @ResponseBody annotation
@RequestMapping("/Africom/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
//    build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
     return  new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }
//    build get all employee REST API
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
//    build  get employee by id REST API
//    http://localhost:8080/Africom/employees/1
    @GetMapping("{id}")
    public  ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
    return  new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);

    }
//    build update employee API
//    http://localhost:8080/Africom/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee,id),HttpStatus.OK);

    }
//    build delete employee API
//    http://localhost:8080/Africom/employees/1
    @DeleteMapping("{id}")
  public  ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
        employeeService.deleteEmployee(id);
        return  new ResponseEntity<String>("Employee deleted successFully!",HttpStatus.OK);
  }
}
