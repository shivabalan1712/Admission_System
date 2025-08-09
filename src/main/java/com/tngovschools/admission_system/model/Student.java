package com.tngovschools.admission_system.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rollNo;

    private String name;
    private String fatherName;
    private String standard;
    private String section;
    private String email;
    private String phone;
    private String address;
}
