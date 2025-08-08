package com.tngovschools.admission_system.controller;

import com.tngovschools.admission_system.model.Student;
import com.tngovschools.admission_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{rollNo}")
    public Student getStudent(@PathVariable Long rollNo) {
        return studentService.getStudentByRollNo(rollNo)
                .orElseThrow(() -> new RuntimeException("Student not found with rollNo: " + rollNo));
    }

    @PutMapping("/{rollNo}")
    public Student updateStudent(@PathVariable Long rollNo, @RequestBody Student student) {
        return studentService.updateStudent(rollNo, student)
                .orElseThrow(() -> new RuntimeException("Student not found with rollNo: " + rollNo));
    }

    @DeleteMapping("/{rollNo}")
    public String deleteStudent(@PathVariable Long rollNo) {
        return studentService.deleteStudent(rollNo)
                ? "Student deleted successfully"
                : "Student not found";
    }
}
