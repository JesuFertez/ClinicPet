package com.coworkers.clinicpet.service;

import com.coworkers.clinicpet.model.Pet;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetService {

    List<Pet> pets = new ArrayList<>();

    public Pet getPetById(Long id) {
        for (Pet pet : pets) {
            if (pet.getPetId().equals(id)) {
                return pet;
            }
        }
        throw new RuntimeException("Pet not foun");
    }
    public void savePet(Pet pet) {
       this.pets.add(pet);
    }
}
