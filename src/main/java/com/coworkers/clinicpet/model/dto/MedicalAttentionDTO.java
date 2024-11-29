package com.coworkers.clinicpet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MedicalAttentionDTO {//Atenciones medicas, detalle consultas
    private Long id;
    private String observations;
    private String notes;
    private String treatments;
}
