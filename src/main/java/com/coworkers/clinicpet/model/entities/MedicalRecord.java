package com.coworkers.clinicpet.model.entities;

import com.coworkers.clinicpet.model.State;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MedicalRecord { //Ficha medica
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ElementCollection //para que guarde un listado de vacunas en una tabla aparte
    @CollectionTable(name = "pet_vaccines", joinColumns=@JoinColumn(name="pet_id",foreignKey = @ForeignKey(name = "fk_pet_vaccines_pet")))
    @Column(name = "vaccines")
    private List<String> vaccines;

    private int weight;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private State state;

    @OneToOne(mappedBy = "medicalRecord")
    private Pet patient;
}
