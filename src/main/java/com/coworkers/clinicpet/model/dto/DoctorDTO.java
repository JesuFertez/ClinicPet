package com.coworkers.clinicpet.model.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
    private Long id;
    private String name;
    private String lastName;
    private String specialty;
    private List<ScheduleAMedicalAppointmentsDTO> appoinments;
}
