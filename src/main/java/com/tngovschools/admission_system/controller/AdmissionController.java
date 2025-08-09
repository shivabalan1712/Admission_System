package com.tngovschools.admission_system.controller;

import com.tngovschools.admission_system.dto.AdmissionDTO;
import com.tngovschools.admission_system.model.Admission;
import com.tngovschools.admission_system.model.AdmissionStatus;
import com.tngovschools.admission_system.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admissions")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @PostMapping
    public Admission createAdmission(@RequestBody AdmissionDTO admissionDTO) {
        return admissionService.createAdmission(admissionDTO.getStudentRollNo(), admissionDTO.getCourseName());
    }

    @GetMapping
    public List<Admission> getAllAdmissions() {
        return admissionService.getAllAdmissions();
    }

    @GetMapping("/{id}")
    public Admission getAdmissionById(@PathVariable Long id) {
        return admissionService.getAdmissionById(id)
                .orElseThrow(() -> new RuntimeException("Admission not found with id: " + id));
    }

    @PutMapping("/{id}/status")
    public Admission updateAdmissionStatus(@PathVariable Long id, @RequestParam AdmissionStatus status) {
        return admissionService.updateStatus(id, status)
                .orElseThrow(() -> new RuntimeException("Admission not found with id: " + id));
    }

    @DeleteMapping("/{id}")
    public String deleteAdmission(@PathVariable Long id) {
        return admissionService.deleteAdmission(id)
                ? "Admission deleted successfully"
                : "Admission not found";
    }
}
