package com.coworkers.clinicpet.service;import com.coworkers.clinicpet.model.dto.PetDTO;import com.coworkers.clinicpet.model.entities.Pet;import com.coworkers.clinicpet.repository.PetRepository;import lombok.RequiredArgsConstructor;import org.modelmapper.ModelMapper;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.stereotype.Service;import java.util.ArrayList;import java.util.List;import java.util.Optional;import java.util.stream.Collectors;@Service@RequiredArgsConstructorpublic class PetService {    private final List<Pet> pets = new ArrayList<>();    @Autowired    private final PetRepository petRepository;    @Autowired    private ModelMapper modelMapper;    public PetDTO createPet(PetDTO dto) {        Pet pet = modelMapper.map(dto, Pet.class);        return modelMapper.map(petRepository.save(pet), PetDTO.class);    }    public List<PetDTO> getAllPets() {        List<Pet> pets = petRepository.findAll();        return pets.stream()                .map(pet -> modelMapper.map(pet, PetDTO.class)                )                .collect(Collectors.toList());    }    public Pet getUserById(long id) {        Optional<Pet> pet = petRepository.findById(id); // Buscar el pet en la base de datos        if (pet.isEmpty()) {            throw new RuntimeException("Pet not found");        }        return pet.get(); // Retornar el pet si lo encuentra    }    public Pet savePet(Pet pet) {        if (pet.getName().trim().isEmpty()) {            throw new RuntimeException();        }        return petRepository.save(pet);    }}