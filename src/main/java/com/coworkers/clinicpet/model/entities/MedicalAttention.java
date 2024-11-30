package com.coworkers.clinicpet.model.entities;

import com.coworkers.clinicpet.model.dto.ScheduleAMedicalAppoinmentsDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class MedicalAttention {//Atenciones medicas, detalle consultas
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observations;
    private String notes;
    private String treatments;

    @ManyToOne
    @JoinColumn(name="appointment_id",referencedColumnName = "id")
    private ScheduleAMedicalAppoinments appointment;
}
