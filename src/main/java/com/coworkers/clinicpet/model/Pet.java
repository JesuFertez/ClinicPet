package com.coworkers.clinicpet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Pet {
    private Long PetId;
    private String name;
    private int age;
    //private Owner owner;
}
