package com.coworkers.clinicpet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class MedicalRecord { //Ficha medica
    private Long id;
    private List <String> vaccines;
    private int weigth;
    private State state;
    private Pet patient;
}
