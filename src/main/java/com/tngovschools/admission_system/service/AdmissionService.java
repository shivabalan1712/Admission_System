package com.tngovschools.admission_system.service;

import com.tngovschools.admission_system.dto.AdmissionDTO;
import com.tngovschools.admission_system.model.*;
import com.tngovschools.admission_system.repository.*;

import lombok.Data;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Optional;
@Data

@Service
public class AdmissionService {

    @Autowired
    private AdmissionRepo admissionRepo;

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Admission convertToEntity(AdmissionDTO admissionDTO) {
        return modelMapper.map(admissionDTO, Admission.class);
    }

    public AdmissionDTO convertToDto(Admission admission) {
        return modelMapper.map(admission, AdmissionDTO.class);
    }


    public Admission createAdmission(Long studentRollNo, String courseName) {
        Student student = studentRepo.findById(studentRollNo)
                .orElseThrow(() -> new RuntimeException("Student not found with rollNo: " + studentRollNo));

        Admission admission = new Admission();
        admission.setStudentRollNo(student);
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
