package com.coworkers.clinicpet.service;import com.coworkers.clinicpet.model.entities.Pet;import com.coworkers.clinicpet.repository.PetRepository;import lombok.RequiredArgsConstructor;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.ArrayList;import java.util.List;import java.util.Optional;@Service@RequiredArgsConstructorpublic class PetService {    private final List<Pet> pets = new ArrayList<>();    @Autowired    private final PetRepository petRepository;    public Pet getUserById(long id) {        Optional<Pet> pet = petRepository.findById(id); // Buscar el pet en la base de datos        if (pet.isEmpty()) {            throw new RuntimeException("Pet not found");        }        return pet.get(); // Retornar el pet si lo encuentra    }    public Pet savePet(Pet pet) {        if (pet.getName().trim().isEmpty()) {            throw new RuntimeException();        }       return petRepository.save(pet);    }}