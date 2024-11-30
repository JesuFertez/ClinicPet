package com.coworkers.clinicpet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Setter
@AllArgsConstructor
@Getter
public class MedicalHistoryDTO {
    private Long id;
    private List<ScheduleAMedicalAppoinmentsDTO> scheduleAMedicalAppoinments;
}
