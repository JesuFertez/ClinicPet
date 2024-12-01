package com.coworkers.clinicpet.model.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

//    @OneToMany(mappedBy = "medicalHistory")
    @OneToMany(mappedBy = "medicalHistory", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ScheduleAMedicalAppointments> scheduleAMedicalAppointments;
}
