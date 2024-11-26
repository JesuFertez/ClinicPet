package com.coworkers.clinicpet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class MedicalRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private List <String> vaccines;
    private int weigth;
    private State state;
    private String observations;
    private String notes;
    @OneToOne
    @JoinColumn(name= "pet_id")
    private Pet patient;

    @OneToMany(mappedBy = "medicalRecord")
    private List<MedicalHistory> medicalHistories;

}
