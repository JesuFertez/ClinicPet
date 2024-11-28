package com.coworkers.clinicpet.model.dto;

import com.coworkers.clinicpet.model.TypeOfAppoinments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ScheduleAMedicalAppoinments { //Agendar cita
    private Long id;
    private LocalDate date;
    private TypeOfAppoinments typeOfAppoinment;
    private Pet patient;
    private Doctor doctor;
    private MedicalAttention medicalAttention;
}
