package com.coworkers.clinicpet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MedicalAttention {//Atenciones medicas, detalle consultas
    private Long id;
    private String observations;
    private String notes;
    private String treatments;
}
