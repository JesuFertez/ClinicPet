package com.coworkers.clinicpet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class MedicalHistoryDTO {
    private Long id;
    private List<ScheduleAMedicalAppointmentsDTO> scheduleAMedicalAppointments;
}
