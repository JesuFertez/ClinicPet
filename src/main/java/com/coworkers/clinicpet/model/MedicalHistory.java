package com.coworkers.clinicpet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Setter
@AllArgsConstructor
@Getter
public class MedicalHistory {
    private Long id;
    private List<ScheduleAMedicalAppoinments> scheduleAMedicalAppoinments;
}
