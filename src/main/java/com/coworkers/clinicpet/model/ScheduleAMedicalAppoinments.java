package com.coworkers.clinicpet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class ScheduleAMedicalAppoinments { //Agendar cita
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private TypeOfAppoinments typeOfAppoinment;
    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id")
    private Pet patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id",referencedColumnName = "id")
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "medicalAtention_id", referencedColumnName = "id")
    private MedicalAttention medicalAttention;
}