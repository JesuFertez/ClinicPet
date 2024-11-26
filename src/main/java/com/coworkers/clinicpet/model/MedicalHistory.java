package com.coworkers.clinicpet.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MedicalHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime dateTime;
    private String description;

    @ManyToOne
    @JoinColumn(name = "medicalRecord_id")
    private List <MedicalRecord> medicalRecords;
}
