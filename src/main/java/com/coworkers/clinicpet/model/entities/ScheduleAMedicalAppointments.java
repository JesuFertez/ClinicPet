package com.coworkers.clinicpet.model.entities;

import com.coworkers.clinicpet.model.TypeOfAppoinments;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ScheduleAMedicalAppointments { //Agendar cita
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @JoinColumn(name = "medical_history_id")
    @ManyToOne
    @JoinColumn(name = "medical_history_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_schedule_medical_history"))
    private MedicalHistory medicalHistory;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate date;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeOfAppoinments typeOfAppointment;

    @ManyToOne
    @JoinColumn(name = "pet_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_schedule_pet"))
    private Pet patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_schedule_doctor"))
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "medical_attention_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_schedule_medical_attention"))
    private MedicalAttention medicalAttention;
}
