package com.tngovschools.admission_system.service;

import com.tngovschools.admission_system.model.Student;
import com.tngovschools.admission_system.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student createStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public Optional<Student> getStudentByRollNo(Long rollNo) {
        return studentRepo.findById(rollNo);
    }

    public Optional<Student> updateStudent(Long rollNo, Student updatedStudent) {
        return studentRepo.findById(rollNo)
                .map(existingStudent -> {
                    existingStudent.setName(updatedStudent.getName());
                    existingStudent.setFatherName(updatedStudent.getFatherName());
                    existingStudent.setStandard(updatedStudent.getStandard());
                    existingStudent.setSection(updatedStudent.getSection());
                    existingStudent.setEmail(updatedStudent.getEmail());
                    existingStudent.setPhone(updatedStudent.getPhone());
                    existingStudent.setAddress(updatedStudent.getAddress());
                    return studentRepo.save(existingStudent);
                });
    }

    public boolean deleteStudent(Long rollNo) {
        if (studentRepo.existsById(rollNo)) {
            studentRepo.deleteById(rollNo);
            return true;
        }
        return false;
    }
}
