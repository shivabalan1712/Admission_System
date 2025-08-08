package com.tngovschools.admission_system.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "student")
public class Student {
    @Id
    private long rollNo;

    private String name;
    private String fatherName;
    private String standard;
    private String section;
    private String email;
    private String phone;
    private String address;
}
