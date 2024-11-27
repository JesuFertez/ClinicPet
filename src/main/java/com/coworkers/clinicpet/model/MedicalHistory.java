package com.coworkers.clinicpet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
