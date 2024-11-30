package com.coworkers.clinicpet.controller;


import com.coworkers.clinicpet.model.dto.DoctorDTO;
import com.coworkers.clinicpet.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors") //URL CONTROLLER
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
        List<DoctorDTO> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors); // code 200ok
    }

    @PostMapping
    public ResponseEntity<DoctorDTO> createDoctor(@RequestBody DoctorDTO doctorDTO) {
        DoctorDTO newDoctor = doctorService.createDoctor(doctorDTO);
        return ResponseEntity.status(201).body(newDoctor); //CODE 201 CREATED
    }

}

