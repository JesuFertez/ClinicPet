package com.coworkers.clinicpet.model.dto;

import com.coworkers.clinicpet.model.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class MedicalRecordDTO { //Ficha medica
    private Long id;
    private List <String> vaccines;
    private int weight;
    private State state;
    private PetDTO patient;
}
