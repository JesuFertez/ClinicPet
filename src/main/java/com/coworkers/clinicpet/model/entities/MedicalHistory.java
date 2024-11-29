package com.coworkers.clinicpet.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MedicalHistory {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany
    private List<ScheduleAMedicalAppoinments> scheduleAMedicalAppoinments;
}
