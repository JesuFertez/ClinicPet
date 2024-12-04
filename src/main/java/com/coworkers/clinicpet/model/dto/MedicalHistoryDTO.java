package com.coworkers.clinicpet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistoryDTO {
    private Long id;
    private List<ScheduleAMedicalAppointmentsDTO> scheduleAMedicalAppointments;
}
