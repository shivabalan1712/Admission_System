package com.tngovschools.admission_system.controller;

import com.tngovschools.admission_system.model.Admission;
import com.tngovschools.admission_system.repository.AdmissionRepo;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdmissionController {

    @Autowired
    AdmissionRepo admissionRepo;

    @PostMapping("/newAdmission")
    public Admission addPerson(@RequestBody Admission admission) {
        admissionRepo.save(admission);
        return admission;
    }

    @GetMapping("/allAdmissions")
    public List<Admission> getAllAdmissions() {
        return admissionRepo.findAll();
    }
}
