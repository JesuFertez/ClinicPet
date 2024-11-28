package com.coworkers.clinicpet.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
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
