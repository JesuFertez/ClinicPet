package com.coworkers.clinicpet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Owner {
    private Long id;
    private String firstName;
    private String lastName;
    private Pet pet;
}
