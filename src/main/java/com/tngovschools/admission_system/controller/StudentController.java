package com.tngovschools.admission_system.controller;

import com.tngovschools.admission_system.model.Student;
import com.tngovschools.admission_system.repository.StudentRepo;
import com.tngovschools.admission_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    StudentRepo studentRepo;

    @GetMapping("/addStudent")
    public String createStudent(Student student) {
        studentRepo.save(student);
        return "Success";
    }

    @PostMapping
    public String updateStudent(@RequestBody Student student) {
        for(Student s: studentRepo.findAll()) {
            if(s.getRollNo() == student.getRollNo()) {
                studentRepo.save(student);
            }
        }
        return "Student updated Successfully";
    }
}
