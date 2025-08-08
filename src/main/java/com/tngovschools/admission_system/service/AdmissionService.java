package com.tngovschools.admission_system.service;

import com.tngovschools.admission_system.model.Admission;
import com.tngovschools.admission_system.model.AdmissionStatus;
import com.tngovschools.admission_system.repository.AdmissionRepo;
import com.tngovschools.admission_system.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepo admissionRepo;

    @Autowired
    private StudentRepo studentRepo;

    public Admission createAdmission(Long studentRollNo, String courseName) {
        var student = studentRepo.findById(studentRollNo)
                .orElseThrow(() -> new RuntimeException("Student not found with rollNo: " + studentRollNo));

        Admission admission = new Admission();
        admission.setStudent(student);
        admission.setCourseName(courseName);
        admission.setStatus(AdmissionStatus.APPLIED);

        return admissionRepo.save(admission);
    }

    public List<Admission> getAllAdmissions() {
        return admissionRepo.findAll();
    }

    public Optional<Admission> getAdmissionById(Long id) {
        return admissionRepo.findById(id);
    }

    public Optional<Admission> updateStatus(Long admissionId, AdmissionStatus newStatus) {
        return admissionRepo.findById(admissionId)
                .map(admission -> {
                    admission.setStatus(newStatus);
                    return admissionRepo.save(admission);
                });
    }

    public boolean deleteAdmission(Long id) {
        if (admissionRepo.existsById(id)) {
            admissionRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
