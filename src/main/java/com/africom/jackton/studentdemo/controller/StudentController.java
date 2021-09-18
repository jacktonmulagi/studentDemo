package com.africom.jackton.studentdemo.controller;

import com.africom.jackton.studentdemo.model.Student;
import com.africom.jackton.studentdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/add")
    public  String add(@RequestBody Student student)
    {
        studentService.saveStudent(student);
        return  "New student is added";
    }
    @GetMapping("/getAll")
    public List<Student> getAllStudents(){
        return  studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable Integer id){


           return studentService.getStudent(id);



    }
}
