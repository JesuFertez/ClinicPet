package com.coworkers.clinicpet.controller;

import com.coworkers.clinicpet.model.Pet;
import com.coworkers.clinicpet.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping("/pets/{petId}")
    public ResponseEntity<Pet> getPetById(@PathVariable long petId) {
        return ResponseEntity.ok(petService.getPetById(petId));
    }

    @PostMapping("/pets")
    public ResponseEntity<Void> savePet(@RequestBody Pet pet) {
        petService.savePet(pet);
        return ResponseEntity.status(201).build();
    }
}
