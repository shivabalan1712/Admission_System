package com.tngovschools.admission_system.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name ="admission")
public class Admission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
}
