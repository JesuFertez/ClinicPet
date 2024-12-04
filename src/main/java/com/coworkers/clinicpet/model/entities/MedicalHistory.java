package com.coworkers.clinicpet.model.entities;

import com.coworkers.clinicpet.model.dto.MedicalHistoryDTO;
import com.coworkers.clinicpet.util.NotFoundException;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String medicalHistoryDetails;

    @OneToMany(mappedBy = "medicalHistory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScheduleAMedicalAppointments> scheduleAMedicalAppointments;

    @OneToOne(mappedBy = "medicalHistory")
    private Pet pet;
}
