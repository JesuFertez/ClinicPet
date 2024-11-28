package com.coworkers.clinicpet.model.entities;

import com.coworkers.clinicpet.model.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
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
