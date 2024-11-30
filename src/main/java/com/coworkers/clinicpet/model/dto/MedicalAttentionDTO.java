package com.coworkers.clinicpet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicalAttentionDTO {//Atenciones medicas, detalle consultas
    private Long id;
    private String observations;
    private String notes;
    private String treatments;
}
