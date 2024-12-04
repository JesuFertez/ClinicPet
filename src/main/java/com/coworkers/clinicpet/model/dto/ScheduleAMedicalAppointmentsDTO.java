package com.coworkers.clinicpet.model.dto;

import com.coworkers.clinicpet.model.TypeOfAppoinments;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ScheduleAMedicalAppointmentsDTO { //Agendar cita
    private Long id;
    private LocalDate date;
    private TypeOfAppoinments typeOfAppointment;
    private PetDTO patient;
    private DoctorDTO doctorDTO;
    private MedicalAttentionDTO medicalAttentionDTO;
}
