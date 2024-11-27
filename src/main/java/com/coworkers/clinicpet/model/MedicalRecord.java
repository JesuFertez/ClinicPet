package com.coworkers.clinicpet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@Entity
public class MedicalRecord { //Ficha medica
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private List <String> vaccines;
    private int weigth;
    private State state;

    @OneToOne(mappedBy = "medicalRecord")
    private Pet patient;
}
