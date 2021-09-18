package com.africom.jackton.studentdemo.service;

import com.africom.jackton.studentdemo.model.Student;

import java.util.List;

public interface StudentService {
    public Student saveStudent(Student student);
    public List<Student> getAllStudents();
    public Student getStudent(Integer id);
}
