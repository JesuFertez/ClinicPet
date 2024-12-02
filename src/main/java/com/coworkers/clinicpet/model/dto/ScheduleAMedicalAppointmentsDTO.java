package com.coworkers.clinicpet.model.dto;

import com.coworkers.clinicpet.model.TypeOfAppoinments;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ScheduleAMedicalAppointmentsDTO { //Agendar cita
    private Long id;
    private LocalDate date;
    private TypeOfAppoinments typeOfAppoinment;
    private PetDTO patient;
    private DoctorDTO doctorDTO;
    private MedicalAttentionDTO medicalAttentionDTO;
}