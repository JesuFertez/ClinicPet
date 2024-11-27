package com.coworkers.clinicpet.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
@Getter
@Entity
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany
    private List<ScheduleAMedicalAppoinments> scheduleAMedicalAppoinments;
}
