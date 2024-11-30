package com.coworkers.clinicpet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private Long id;
    private String name;
    private String lastName;
    private String specialty;
    private List<ScheduleAMedicalAppoinmentsDTO> appoinments;

}
