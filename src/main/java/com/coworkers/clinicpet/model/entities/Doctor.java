package com.coworkers.clinicpet.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String name;
    private String lastName;
    private String specialty;

    @OneToMany(mappedBy = "doctor")
    private List<ScheduleAMedicalAppoinments> appoinments;

}
