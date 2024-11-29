package com.coworkers.clinicpet.model.entities;

import com.coworkers.clinicpet.model.State;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MedicalRecord { //Ficha medica
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @ElementCollection //para que guarde un listado de vacunas en una tabla aparte
    @CollectionTable(name = "pet_vaccines", joinColumns=@JoinColumn(name="pet_id"))
    @Column(name = "vaccines")
    private List<String> vaccines;
    private int weigth;
    private State state;

    @OneToOne(mappedBy = "medicalRecord")
    private Pet patient;
}