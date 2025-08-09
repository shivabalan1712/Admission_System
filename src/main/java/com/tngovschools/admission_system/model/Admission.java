package com.tngovschools.admission_system.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "admission")
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_roll_no", nullable = false)
    private Student studentRollNo;

    private String courseName;

    @Enumerated(EnumType.STRING)
    private AdmissionStatus status;

    private LocalDateTime appliedAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        appliedAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
