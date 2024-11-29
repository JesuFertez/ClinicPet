package com.coworkers.clinicpet.model.entities;

import com.coworkers.clinicpet.model.TypeOfAppoinments;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
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
