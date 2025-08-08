package com.tngovschools.admission_system.repository;

import com.tngovschools.admission_system.model.Admission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface AdmissionRepo extends JpaRepository<Admission, Long> {
}
