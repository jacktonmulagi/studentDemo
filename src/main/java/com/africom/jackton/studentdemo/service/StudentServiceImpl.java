package com.africom.jackton.studentdemo.service;

import com.africom.jackton.studentdemo.model.Student;
import com.africom.jackton.studentdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImpl  implements StudentService{
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public  Student getStudent(Integer id){
        return (Student) studentRepository.findAllById(Collections.singleton(id));
    }
}
