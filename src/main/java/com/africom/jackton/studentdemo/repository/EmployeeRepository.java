package com.africom.jackton.studentdemo.repository;

import com.africom.jackton.studentdemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//no need to use @Repository since Spring Data JPA internally provides @Repository Annotation ,we do not need to add @Repository annotation to EmployeeRepository interface
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {
}
