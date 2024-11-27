package com.coworkers.clinicpet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Doctor {
    private Long id;
    private String name;
    private String lastName;
    private String specialty;
    private List<ScheduleAMedicalAppoinments> appoinments;

}
